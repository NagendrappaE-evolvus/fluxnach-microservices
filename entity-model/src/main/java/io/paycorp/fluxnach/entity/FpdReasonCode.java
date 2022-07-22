/**
 * 
 */
package io.paycorp.fluxnach.entity;

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
public class FpdReasonCode {

	@Id
	@SequenceGenerator(name = "FPD_REASON_CODE_SEQ")
	private Long rsnId;

	private String rsnCode;

	private String rsnDesc;

	private String rsnCategory;

	private String rsnSource;

	private String rsnMapCode;

	private int delFlag;

}
