/**
 * 
 */
package io.paycorp.fluxnach.entity;

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
public class FpdReasonCode {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "FPD_REASON_CODE_SEQ")
	@SequenceGenerator(sequenceName = "FPD_REASON_CODE_SEQ", name = "FPD_REASON_CODE_SEQ",allocationSize = 1)
	private Long rsnId;

	private String rsnCode;

	private String rsnDesc;

	private String rsnCategory;

	private String rsnSource;

	private String rsnMapCode;

	private int delFlg;

}
