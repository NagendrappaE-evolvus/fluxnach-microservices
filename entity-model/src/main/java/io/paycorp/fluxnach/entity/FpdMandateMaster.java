/**
 * 
 */
package io.paycorp.fluxnach.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "FPD_MANDATE_MASTER_SEQ")
	@SequenceGenerator(sequenceName = "FPD_MANDATE_MASTER_SEQ", name = "FPD_MANDATE_MASTER_SEQ",allocationSize = 1)
	@Id
	private Long mndmId;

	private String umrn;

	private String spoBankCode;

	private String orgOic;

	private String instCode;

	private String payerAcctType;

	private String payerAcctNum;

	private String payBankCode;

	private String mndAmtType;

	private BigDecimal mndMinAmt;

	private BigDecimal mndMaxAmt;

	private String mndConsumerRef;

	private String batchRefNum;

	private String schemeRef;

	private int drInstAllowed;

	private String mndFreq;

	private int mndDefDays;

	private Date mndStartDt;

	private Date mndExpireDt;

	private String untilCancel;

	private String payerName;

	private String payerContact;

	private String payerEmail;

	private String payerMobileCont;

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
