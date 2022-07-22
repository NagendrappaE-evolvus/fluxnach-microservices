/**
 * 
 */
package io.paycorp.fluxnach.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

/**
 * @author nagendrappae
 *
 */
@Entity
@Data
public class FpdOrg {

	@Id
	@SequenceGenerator(name = "FPD_ORG_SEQ")
	private Long orgMId;

	private String orgRefNo;

	private String orgOic;

	private String orgTypeCode;

	private String orgName;

	private String orgAddress1;

	private String orgAddress2;

	private String orgAddress3;

	private String orgAddress4;

	private String orgCity;

	private String orgState;

	private String orgWebSite;

	private String orgRegdToAuth;

	private String orgRegdIdNum;

	private Date orgRegdIdIssueDate;

	private Date orgRegdIdExpireDate;

	/*
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "ORG_PRIM_CONT_ID", nullable = true) private Contacts
	 * primaryContact;
	 * 
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "ORG_HDSK_CONT_ID", nullable = true) private Contacts
	 * helpDeskContact;
	 * 
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "ORG_SECO_CONT_ID", nullable = true) private Contacts
	 * secondaryContact;
	 */

	private int delFlg;

	private Date crtDatetime;

	private int crtEntityId;

	private String orgFirstSpBank;

	private int orgSpBankCnt;

	private Date lastModifiedDt;

	private int portedOic;

	private String mndAutoCollect;

	private int autoApproveFlag;

	private String mndRef1Required;

}
