/**
 * 
 */
package io.paycorp.fluxnach.entity;

import javax.persistence.Entity;
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
	@SequenceGenerator(name = "FPD_SEQ_NUMBER_SEQ")
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
