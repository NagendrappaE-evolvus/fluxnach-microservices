/**
 * 
 */
package io.paycorp.fluxnach.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import lombok.Data;

/**
 * @author nagendrappae
 *
 */
@Entity
@Data
public class FpdSeqNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "FPD_SEQ_NUMBER_SEQ")
	@SequenceGenerator(sequenceName = "FPD_SEQ_NUMBER_SEQ", name = "FPD_SEQ_NUMBER_SEQ",allocationSize = 1)
	private Long id;

	private String seqCode;

	private String seqValue;

	private String maxValue;

	private String resetValue;

	private String resetFreq;

	private String seqDesc;

	private String seqType;

	@Version
	protected Long version;

}
