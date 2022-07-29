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

import lombok.Data;

/**
 * @author nagendrappae
 *
 */
@Entity
@Data
public class FpdFileInout {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "FPD_FILE_INOUT_SEQ")
	@SequenceGenerator(sequenceName = "FPD_FILE_INOUT_SEQ", name = "FPD_FILE_INOUT_SEQ",allocationSize = 1)
	private Long batchId;

	private String msgType;

	private String generatedFileName;

	private String fileData;

	private String srcMsgType;

	private String BatchRef;

	private String senderCode;

	private String senderRefNum;

	private Long batchItemCnt;

	private String param1;

	private String batchFileName;

	private String batchStatus;

	private Date fileDttime;

	private String param2;

	private String param3;

	private String param4;

	private String param5;

	private String param6;

	private String param7;

	private String param8;

	private String param9;

	private String param10;

	private String param11;

	private String param12;

	private String param13;

	private String param14;

	private String param15;

	private String param16;

	private String param17;

	private Long param18;

	private String param19;

	private String param20;

	private String itemSeq;

	private String checksum;

	private String fileRefNum;

	private String fileCategory;

	private Date processDate;

	private String errorFileName;

	private String txnCode;
	
	private String orgClaimNum;

	@Id
	@Transient
	private Date creationTime;

	@Id
	@Transient
	private String recordId;

	@Id
	@Transient
	private String recordEndId;

	@Id
	@Transient
	private String headerFiller;

	@Transient
	private BigDecimal unSettledAmount;

	@Transient
	private BigDecimal extendedAmt;

	@Transient
	private String extendedCount;

	@Id
	@Transient
	private BigDecimal amount;

	public BigDecimal getAmount() {
		return new BigDecimal(this.param1).multiply(new BigDecimal(100));
	}

	public void setAmount(BigDecimal amount) {
		amount = amount.divide(new BigDecimal("100"));
		this.param1 = amount.toString();
	}

	@Id
	@Transient
	private String userName;

	@Id
	@Transient
	private BigDecimal totalAmt;

	@Transient
	private String count;
}
