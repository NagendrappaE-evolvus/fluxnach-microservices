/**
 * 
 */
package io.paycorp.fluxnach.outwardpaymentserver.processor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.paycorp.fluxnach.commonservice.GenericReferenceService;
import io.paycorp.fluxnach.entity.FpdFileErr;
import io.paycorp.fluxnach.entity.FpdFileInout;
import io.paycorp.fluxnach.entity.FpdMandateMaster;
import io.paycorp.fluxnach.entity.FpdOrg;
import io.paycorp.fluxnach.entity.FpdOrgDtl;
import io.paycorp.fluxnach.entity.FpdPaymentOut;
import io.paycorp.fluxnach.entity.FpdReasonCode;
import io.paycorp.fluxnach.entity.service.FpdFileErrService;
import io.paycorp.fluxnach.entity.service.FpdFileInoutService;
import io.paycorp.fluxnach.entity.service.FpdMandateMasterService;
import io.paycorp.fluxnach.entity.service.FpdOrgDtlService;
import io.paycorp.fluxnach.entity.service.FpdOrgService;
import io.paycorp.fluxnach.entity.service.FpdPaymentOutService;
import io.paycorp.fluxnach.entity.service.FpdReasonCodeService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author nagendrappae
 *
 */
@Component
@Slf4j
public class FileUploadProcessor implements Processor {

	private static final String MND_STS = "0";

	private ArrayList<String> errorMsgList;

	@Autowired
	private FpdMandateMasterService fpdMandateMasterService;

	@Autowired
	private FpdOrgService fpdOrgService;

	@Autowired
	private FpdOrgDtlService fpdOrgDtlService;

	@Autowired
	private FpdReasonCodeService fpdReasonCodeService;

	@Autowired
	private FpdFileErrService fpdFileErrService;

	@Autowired(required = true)
	@Qualifier("ODEDR_SpoBnkTxnNum")
	private GenericReferenceService spogenericReferenceService;

	@Autowired
	private FpdFileInoutService fpdFileInoutService;
	
	
	@Autowired
	private FpdPaymentOutService fpdPaymentOutService; 

	private String msgType; // NOSONAR

	private String qStatus;

	private String orgName;

	private String orgAccNum;

	private String orgSpoBank;

	private String fileName;

	@Override
	public void process(Exchange exchange) throws Exception {
		errorMsgList = new ArrayList<>();
		try {
			List<FpdPaymentOut> payList = (List<FpdPaymentOut>) exchange.getIn().getBody();
			FpdFileInout outwardBatchPayment = (FpdFileInout) exchange.getIn().getHeader("outwardBatchPayment");
			fileName = (String) exchange.getIn().getHeader("CamelFileName");
			msgType = fileName.split("~")[0];
			getRecordReferenceNumber(payList);
			String oic = outwardBatchPayment.getParam10();
			getMandate(payList, oic, msgType, outwardBatchPayment);
		} catch (Exception e) {
			log.debug("Exception ::::{}", e);
		}

	}

	private List<FpdPaymentOut> getRecordReferenceNumber(List<FpdPaymentOut> records) {
		String seqVal = spogenericReferenceService.getNextBlockReference(records.size());
		String[] seqArray = spogenericReferenceService.getNextJumpReference(seqVal, 0, "AN");
		records.get(0).setSpoBankUtr(seqArray[0]); // Setting the first
													// Reference
		for (int index = 1; index < records.size(); index++) {
			seqArray = spogenericReferenceService.getNextJumpReference(seqArray[1], 1, "AN");
			records.get(index).setSpoBankUtr(seqArray[0]);
		}
		return records;

	}

	public void getOrgDetails(String oic) {
		Optional<FpdOrg> org = fpdOrgService.findByOrgOic(oic);
		if (!org.isEmpty() && 1 == org.get().getAutoApproveFlag()) {
			qStatus = "PFG-500";
		} else {
			qStatus = "PSA-500";
		}
		orgName = org.get().getOrgName();
		Optional<FpdOrgDtl> orgDtl = fpdOrgDtlService.findByOrgRefNo(org.get().getOrgRefNo());
		orgAccNum = orgDtl.get().getOrgAcctNum();
		orgSpoBank = org.get().getOrgFirstSpBank();
	}

	private void logError(String fieldNumber, String errorData, int i, String errorNum, String txnRefNo) {
		Optional<FpdReasonCode> fpdrsncode = fpdReasonCodeService.findByRsnCode(errorNum);
		String rsnDesc = fpdrsncode.get().getRsnDesc();
		String errorText = "Error in line " + i + ",   '" + errorData + "'," + "ERROR DESC:" + rsnDesc + "\n";
		FpdFileErr fileErr = new FpdFileErr();
		fileErr.setFieldId(fieldNumber);
		fileErr.setRecType("ACH");
		fileErr.setLineNo("" + i);
		fileErr.setErrNo(errorNum);
		fileErr.setErrDesc(errorText);
		fileErr.setRejectedTime(new Date());
		fileErr.setTxnRefNo(txnRefNo);
		fpdFileErrService.save(fileErr);
		errorMsgList.add(errorText);
	}

	public boolean validateMandate(FpdMandateMaster mandate, FpdPaymentOut payment, String msgType, int recCnt,
			String oic) {
		log.debug("Message Type is :: {}", msgType);
		boolean isValid = true;
		if (mandate != null && oic.equals(mandate.getOrgOic())) {
			BigDecimal claimAmt = payment.getClaimAmt();
			if ("V".equalsIgnoreCase(mandate.getMndAmtType())) {
				if (claimAmt.compareTo(mandate.getMndMaxAmt()) == 1) { // NOSONAR
					logError("2", claimAmt.toString(), recCnt, "FPD_ORG1", payment.getSpoBankUtr());
					isValid = false;
				}
			} else if ("F".equalsIgnoreCase(mandate.getMndAmtType())
					&& (claimAmt.compareTo(mandate.getMndMaxAmt()) != 0)) {
				logError("2", claimAmt.toString(), recCnt, "FPD_ORG2", payment.getSpoBankUtr());
				isValid = false;
			}
		} else {
			logError("3", payment.getUmrn(), recCnt, "FPD_ORG3", payment.getSpoBankUtr());
			isValid = false;
		}
		return isValid;
	}

	private void saveData(FpdMandateMaster mandate, FpdPaymentOut payment) {

		payment.setCurCode("INR");
		payment.setPayAcType(mandate.getPayerAcctType());
		payment.setPayAcName(mandate.getPayerName());
		payment.setOrgAcName("");// user name
		payment.setPayBankCode(mandate.getPayBankCode());
		payment.setPayAcNum(mandate.getPayerAcctNum());
		payment.setSpoBankCode(mandate.getSpoBankCode());
		payment.setProdType("10");
		payment.setUmrn(mandate.getUmrn());
		payment.setRecvdDttime(new Date());
		payment.setPayBankSeq(0);
		payment.setSpoBankSeq(0);
	}

	public void getMandate(List<FpdPaymentOut> paymentList, String oic, String msgType,
			FpdFileInout outwardBatchPayment) {
		long validCnt = 0;
		int recCnt = 0;
		getOrgDetails(oic);
		for (FpdPaymentOut payment : paymentList) {
			recCnt++;
			FpdMandateMaster mandate = fpdMandateMasterService.findByUmrnAndMndStatus(payment.getUmrn(), MND_STS);

			boolean isValid = validateMandate(mandate, payment, msgType, recCnt, oic);
			payment.setOrgFilename(fileName);
			payment.setOutBatchRef(outwardBatchPayment.getBatchRef());
			payment.setTxnType("ACH_DR");
			payment.setLastModifiedDt(new Date());
			payment.setTxnCode("67");
			payment.setOrgIdCode(oic);
			if (isValid) {
				validCnt++;
				payment.setUsrName(orgName);
				payment.setOrgAcNum(orgAccNum);
				payment.setTxnCode(qStatus);
				saveData(mandate, payment);
			} else {
				payment.setTxnCode("ERR-500");
			}
			fpdPaymentOutService.save(payment);
		}
		outwardBatchPayment.setFileRefNum(outwardBatchPayment.getBatchRef());

		outwardBatchPayment.setParam6(orgAccNum);
		outwardBatchPayment.setParam3(orgName);
		outwardBatchPayment.setSenderCode(orgSpoBank);
		outwardBatchPayment.setParam18(validCnt);

		fpdFileInoutService.update(outwardBatchPayment);
	}

}
