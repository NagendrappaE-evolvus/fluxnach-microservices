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
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "FPD_PAYMENT_OUT_SEQ")
	@SequenceGenerator(sequenceName = "FPD_PAYMENT_OUT_SEQ", name = "FPD_PAYMENT_OUT_SEQ",allocationSize = 1)
	private Long payRef;

	private String outBatchRef;

	private int spoBankSeq;

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

	private String payAcName;

	private String payAcType;

	private String payAcNum;

	private String payBankCode;

	private String txnCode;

	private String payBankUtr;

	private BigDecimal settledAmt;

	private Date settledDttime;

	private Date recvdDttime;

	private Date claimDate;

	private String recordId;

	private String ddrn;

	private String payNopay;

	private String orgTxnRef;

	private String ddsFileName;

	private String orgSeq;

	private String fileId;

	private Long settleSession;

	private String payStatus;

	private String qStatus;

	private String ldgrFolioNum;

	private String usrName;

	private String usrNum;

	private String prodType;

	private String consRefNum;

	private String cbsHoldRef;

	private String settledPhxDttime;

	private String cbsHoldRefNum;

	private String txnType;

	private String adhaar;

	private BigDecimal aadhaarNum;

	private String customRsnDesc;

	private Date RespDate;

	private String clientCode;

	private String benefAccType;

	private String mndRefNum;

	private String usrFld1;

	private Date usrFld2;

	private String usrFld3;

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
		String name = this.getProdType() + "-" + this.usrName;
		this.usrName = name.substring(0, Math.min(name.length(), 20));

	}

}
