/**
 * 
 */
package io.paycorp.fluxnach.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class FpdOrgDtl {

	@Id
	@SequenceGenerator(name = "FPD_ORG_DTL_SEQ")
	private Long orgDetId;

	private String orgRefNo;

	private String orgOldRefNo;

	private String orgAcctNum;

	private String orgChargAcctNum;
	/**
	 * declared orgPeaCode.
	 */
	private String orgPeaCode;
	/**
	 * declared orgSeaCode.
	 */
	private String orgSeaCode;
	/**
	 * declared orgCnfType.
	 */
	private String orgCnfType;
	/**
	 * declared orgCnfLength.
	 */
	private Long orgCnfLen;
	/**
	 * declared orgCnfSample.
	 */
	private String orgCnfSample;
	/**
	 * declared orgBillFreqCode.
	 */
	private String orgBillFreqCode;
	/**
	 * declared orgCurCustCount.
	 */
	private Long orgCurCustCount;
	/**
	 * declared orgBusinessNature.
	 */
	private String orgBusinessNature;
	/**
	 * declared orgDetailInfo.
	 */

	private String orgDetailInfo;

	private String statementFreq;

	private String chargesPlanCode;

	private String bankSpecificNotes;

	private Date orgConfReviewDttime;

	private String reviewerName;

	private String approval1_UserId;

	private String approval2_UserId;

	// Code added to add the reference number.

	private String doc1_RefNo;

	// *******Sample Bill*********************************
	private String doc2_RefNo;

	// *******Signed UAEDDS Conformity********************
	private String doc3_RefNo;

	// *******Customer Service Agreement Template*********
	private String doc4_RefNo;

	// *******Dispute Resolution Process Document*********
	private String doc5_RefNo;

	private String isDoc1_Collected;

	private String isDoc2_Collected;

	private String isDoc3_Collected;

	private String isDoc4_Collected;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ORG_M_ID", nullable = true)
	private FpdOrg orgMasterId;

	private String qStatus;
	/**
	 * declared delFlag.
	 */
	private int delFlag;

	private int authLevel;

	private int processStatus;

	private int orgTxnFlag;

	private String authComment;

	private String ddsFileName;

	private String crtUsrId;
	private String lastAuthUsrId;

	private String instCode;

	@Id
	@Transient
	private String priemContName;

	@Id
	@Transient
	private String priemContTel;

	@Id
	@Transient
	private String priemContEmail;

	@Id
	@Transient
	private String seacContName;

	@Id
	@Transient
	private String seacContTel;

	@Id
	@Transient
	private String seacContEmail;

	@Id
	@Transient
	private String helpContTel;

	@Id
	@Transient
	private String helpContEmail;

	// for storing the batch file reference
	private String batchRefNum;

	// for storing the conformity batch file reference
	private String confBatchRefNum;

	@Version
	private Long version;

}
