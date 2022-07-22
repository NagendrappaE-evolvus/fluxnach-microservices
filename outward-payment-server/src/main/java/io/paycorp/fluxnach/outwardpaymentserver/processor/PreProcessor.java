/**
 * 
 */
package io.paycorp.fluxnach.outwardpaymentserver.processor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.beanio.BeanReader;
import org.beanio.BeanReaderErrorHandlerSupport;
import org.beanio.InvalidRecordException;
import org.beanio.RecordContext;
import org.beanio.StreamFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import io.paycorp.fluxnach.commonservice.GenericReferenceService;
import io.paycorp.fluxnach.entity.FpdFileInout;
import io.paycorp.fluxnach.entity.FpdPaymentOut;
import io.paycorp.fluxnach.entity.service.FpdFileInoutService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author nagendrappae
 *
 */
@Component
@Slf4j
public class PreProcessor implements Processor {
	private static final String ERR_FILE_NAME_HEADER = "camelErrFileName";

	private static final String FILE_PATH = "CamelFilePath";

	private String path;

	BeanReader beanReader = null;
	StreamFactory factory = null;
	private String streamName;
	private String fileErrName;
	private String fileStatus;

	private String msgType;
	private Resource streamMapping;
	
	
	@Autowired
    @Qualifier("FILE_INOUT_BATCH_SeqNumber")
	private GenericReferenceService genericReferenceService;
	
	private ArrayList<String> errorMsgList;

	@Autowired
	private FpdFileInoutService fpdFileInoutService;

	@Override
	public void process(Exchange exchange) throws Exception { // NOSONAR
		try (InputStream in = streamMapping.getInputStream();
				FileInputStream fis = new FileInputStream((String) exchange.getIn().getHeader(FILE_PATH));
				Reader reader = new InputStreamReader(fis);) {
			fileStatus = "SUCCESS";
			String fileName = (String) exchange.getIn().getHeader("CamelFileName");
			msgType = fileName.split("~")[0];
			fileErrName = (String) exchange.getIn().getHeader(ERR_FILE_NAME_HEADER);
			errorMsgList = new ArrayList<>();
			int recCnt = 0;
			List<FpdPaymentOut> outPaymentList = new ArrayList<>();
			factory = StreamFactory.newInstance();
			factory.load(in);
			beanReader = factory.createReader(streamName, reader);
			FpdPaymentOut outPayment = null;
			FpdFileInout outwardBatchPayment = null;
			outwardBatchPayment = fpdFileInoutService.getByBatchFileName(fileName);
			if (outwardBatchPayment == null) {
				outwardBatchPayment = new FpdFileInout();
				outwardBatchPayment.setBatchRef(genericReferenceService.getNextReference());
			}
			beanReader.setErrorHandler(new BeanReaderErrorHandlerSupport() {
				@Override
				public void invalidRecord(InvalidRecordException ex) throws Exception {
					for (int i = 0, j = ex.getRecordCount(); i < j; i++) {
						RecordContext context = ex.getRecordContext(i);
						if (context.hasRecordErrors()) {
							for (String error : context.getRecordErrors()) {
								// handle record errors...
							}
						}
						if (context.hasFieldErrors()) {
							for (String field : context.getFieldErrors().keySet()) {
								for (String error : context.getFieldErrors(field)) {
									logError(msgType, context.getLineNumber(), field, "ACH001");
								}
							}
						}
					}
				}
			});
			while ((outPayment = (FpdPaymentOut) beanReader.read()) != null) {
				recCnt++;
				outPaymentList.add(outPayment);
			}
			if ("ERROR".equalsIgnoreCase(fileStatus)) {
				outwardBatchPayment.setErrorFileName(fileErrName);
				writeToFile(errorMsgList);
			}

			outwardBatchPayment.setBatchStatus(fileStatus);
			outwardBatchPayment.setTxnCode("56");
			outwardBatchPayment.setBatchItemCount((long) recCnt);
			outwardBatchPayment.setMsgType("ACH_DR");
			outwardBatchPayment.setFileCategory("ACH-500");
			fpdFileInoutService.update(outwardBatchPayment);

			exchange.getIn().setHeader("fileStatus", fileStatus);
			exchange.getOut().setHeaders(exchange.getIn().getHeaders());
			exchange.getOut().setBody(outPaymentList);
			exchange.getIn().setHeader("outwardBatchPayment", outwardBatchPayment);
			beanReader.close();
		} catch (Exception e) {
			log.error("{}", e);
		}
	}
	private void logError(String recType, int lineNum, String fldID,
			String errorNum) {
		fileStatus = "ERROR";
		/*
		 * String rsnDesc = reasonCodeMasterService .getByReasonCode(errorNum);
		 */
		String rsnDesc=null;
		try {
			String errorText = recType + "," + lineNum + "," + recType + "-"
					+ fldID + "," + errorNum + "," + rsnDesc + "\n";
			errorMsgList.add(errorText);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}
	
	public void writeToFile(List<String> errorList) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		try (FileWriter fileWriter = new FileWriter(file + File.separator + fileErrName,
				true);) {
			
			for (String fileLine : errorList) {
				fileWriter.write(fileLine);
			}
		} catch (IOException e) {
			log.debug(e.getMessage());
		} 
	}


}
