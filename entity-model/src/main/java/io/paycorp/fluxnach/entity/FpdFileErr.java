/**
 * 
 */
package io.paycorp.fluxnach.entity;

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
public class FpdFileErr {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "FPD_FILE_ERR_SEQ")
	@SequenceGenerator(sequenceName = "FPD_FILE_ERR_SEQ", name = "FPD_FILE_ERR_SEQ",allocationSize = 1)
	private Long fileErrId;
	
	private String lineNo;
	
	private String txnRefNo;
	
	private String recType;

	private String fieldId;

	private String errNo;

	private String errDesc;
	
	private Date rejectedTime;

	private String batchRefNum;


}
