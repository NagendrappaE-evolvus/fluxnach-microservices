/**
 * 
 */
package io.paycorp.fluxnach.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;

import lombok.Data;

/**
 * @author nagendrappae
 *
 */
@Entity
@Data
public class FpdPaymentOut {

	@Id
	@SequenceGenerator(name = "FPD_PAYMENT_OUT_SEQ")
	private Long payRef;

	private String outBatchRef;

	private int sponBankSeq;

	private long payBankSeq;

	private Date lastModifiedDt;

	private String orgFilename;

	private String spoBankCode;

	private String spoBankUtr;

	private String orgIdCode;

	private String orgAcName;

	private String orgAcNum;

	private String umrn;

	private String curCode;

	private BigDecimal claimAmt;

	private String payAccName;

	private String payAccType;

	private String payAccNum;

	private String payBankCode;

	private String txnCode;

	private String payBankUtr;

	private BigDecimal settledAmt;

	private Date settledDtttime;

	private Date receivedDtttime;

	private Date claimDate;

	private String recordId;

	private String ddrn;

	private String payNopay;

	private String orgTxnRef;

	private String ddsFileName;

	private String orgSeqNum;

	private String fileId;

	private Long settledSession;
	
	private String payStatus;

    private String txnStatusCode;

	private String ldgrFolioNum;

	private String userName;

	private String userNum;

	private String prodType;

	private String consumerRefNumber;

	private String cbsHoldRef;

	private String settledPhxDtttime;
	
	private String cbsHoldReferenceNumber;
	
	private String txnType;

	private String adhaar;

	private BigDecimal aadhaarNum;

	private String customRsnDesc;
	
	private Date RespDate;
	
	private String clientCode;

	private String benefAccType;

	private String mndRefNum;

	private String usrField1;
	
	private Date usrField2;
	
	private String checkSum;

	private String itemSeq;

	@Version
	private Long version;

	@Transient
	private String returnDesc;
	

	@Transient
	private String schemeCode;
	
	@Id
	@Transient
	private int qCount;
	
	@Transient
	@Id
	private String filler;
	
	@Id
	@Transient
	private BigDecimal amount;
	
	@Id
	@Transient
	private Integer settlementStatus;
	
	@Id
	@Transient
	private String respDate; 

	@Id
	@Transient
	private String rsnDescOne; 

	@Id
	@Transient
	private String rsnDescTwo; 


	public void setUserNameWithPrdType() {
		String name = this.getProdType() + "-" + this.userName;
		this.userName = name.substring(0, Math.min(name.length(), 20));

	}

}
