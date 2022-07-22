/**
 * 
 */
package io.paycorp.fluxnach.entity;

import java.math.BigDecimal;
import java.util.Date;

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
public class FpdSysBusiness {

	@Id
	@SequenceGenerator(name = "FPD_SYS_BUSINESS_SEQ")
	private int id;

	private String systemCode;

	private Date curBusinessDt;

	private Date defPresCutOffTime;

	private Date actPresCutOffTime;

	private Date defSettlCutOffTime;

	private Date actSettlCutOfftime;

	private Date extInSettlTime;

	private int businessStatus;

	private Date nxtBusinessDt;
	
	private Date lastBusinessDt;

	private BigDecimal netDebit;
	
	private BigDecimal netcredit;

	private Date lastEodDtTime;

	private String weekHolidays;

	
}
