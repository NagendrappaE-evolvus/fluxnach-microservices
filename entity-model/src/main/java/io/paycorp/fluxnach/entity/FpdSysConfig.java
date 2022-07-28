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
public class FpdSysConfig {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "FPD_SYS_CONFIG_SEQ")
	@SequenceGenerator(sequenceName = "FPD_SYS_CONFIG_SEQ", name = "FPD_SYS_CONFIG_SEQ",allocationSize = 1)
	private int id;
	
    private String paramId;
    
    private String paramParentId;

    private String paramName;
    
    private String paramDesc;

    private String paramValue;

    private int delFlg;
    
    private String paramInfo1;
    
    private String paramInfo2;



}
