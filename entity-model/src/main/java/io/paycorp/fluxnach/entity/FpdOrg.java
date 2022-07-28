/**
 * 
 */
package io.paycorp.fluxnach.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "FPD_ORG_SEQ")
	@SequenceGenerator(sequenceName = "FPD_ORG_SEQ", name = "FPD_ORG_SEQ",allocationSize = 1)
	private Long org_M_Id;

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

	private Date orgRegdIdIssDt;

	private Date orgRegdIdExpDt;

	private String refCode;

	private int delFlg;

	private Date crtDatetime;

	private int crtEntityId;

	private String orgFirstSpBank;

	private int orgSpBankCnt;

	private Date lastModifiedDt;

	private int portedOic;

	private String mndAutoCollect;

	private int autoApproveFlag;

	private String mndRef1_required;

	private String reqStatus;

	private String orgCrtDatetime;

	private long orgHdskContId;

	private long orgPrimContId;
	
	private long orgSecoContId;

}
