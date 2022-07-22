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
public class FpdSysConfig {

	
	@Id
	@SequenceGenerator(name = "FPD_SYS_CONFIG_SEQ")
	private int id;
	
    private String paramId;
    
    private String paramParentId;

    private String paramName;
    
    private String paramDesc;

    private String paramValue;

    private int delFlag;
    
    private String paramInfoOne;
    
    private String paramInfoTwo;



}
