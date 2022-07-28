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

import lombok.Data;

/**
 * @author nagendrappae
 *
 */
@Entity
@Data
public class FpdSysBusiness {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "FPD_SYS_BUSINESS_SEQ")
	@SequenceGenerator(sequenceName = "FPD_SYS_BUSINESS_SEQ", name = "FPD_SYS_BUSINESS_SEQ",allocationSize = 1)
	private int id;

	private String systemCode;

	private Date curBusinessDt;

	private Date defPresCutoffTime;

	private Date actPresCutoffTime;

	private Date defSettlCutoffTime;

	private Date actSettlCutoffTime;

	private Date extInSettlTime;

	private int businessStatus;

	private Date nextBusinessDt;
	
	private Date lastBusinessDt;

	private BigDecimal netDebit;
	
	private BigDecimal netCredit;

	private Date lastEodDttime;

	private String weekHolidays;

	
}
