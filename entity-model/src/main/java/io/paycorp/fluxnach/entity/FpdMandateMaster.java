/**
 * 
 */
package io.paycorp.fluxnach.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import lombok.Data;

/**
 * @author nagendrappae
 *
 */
@Entity
@Data
public class FpdMandateMaster {

	@Id
	@SequenceGenerator(name = "FPD_MANDATE_MASTER_SEQ")
	private Long mndId;

	private String umrn;

	private String sponserBankCode;

	private String orgOic;

	private String instructionCode;

	private String payerAccountType;

	private String payerAccountNum;

	private String payerBankCode;

	private String amountType;

	private BigDecimal minAmt;

	private BigDecimal maxAmt;

	private String consumerRef;

	private String batchRefNum;

	private String schemeRef;

	private int instanceAllowed;

	private String mndFreq;

	private int mndDefDays;

	private Date mndStartDt;

	private Date mndExpireDt;

	private String untilCancel;

	private String payerName;

	private String payerContact;

	private String payerEmail;

	private String payerMobileCon;

	private String mndCaptureMode;

	private String docRefNum;

	private Date crtdDt;

	private Date lastModifiedDt;

	private int autoCollectionFlag;

	private String chargesPlanCode;

	private int stopPayFlag;

	private String payerType;

	private String payerIdType;

	private String payerIdNum;

	private String purposeCode;

	private String mndCreatedDate;

	private int reinitCnt;

	private String txnCode;

	private String qStatus;

	@Version
	private Long version;

	private String mndStatus;

	private String mndFileName;

	private String mndCategory;

	private String orgName;

	private String mndType;

	private String mndSeqType;

}
