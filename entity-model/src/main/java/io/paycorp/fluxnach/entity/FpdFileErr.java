/**
 * 
 */
package io.paycorp.fluxnach.entity;

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
public class FpdFileErr {

	@Id
	@SequenceGenerator(name = "FPD_FILE_ERR_SEQ")
	private Long fileErrId;
	
	private String lineNo;
	
	private String txnRefNo;
	
	private String recType;

	private String fieldId;

	private String errNo;

	private String errDesc;
	
	private Date errRejectedTime;

	private String batchRefNum;


}
