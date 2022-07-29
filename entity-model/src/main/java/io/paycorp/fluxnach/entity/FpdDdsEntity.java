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
public class FpdDdsEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FPD_DDS_ENTITY_SEQ")
    @SequenceGenerator(name = "FPD_DDS_ENTITY_SEQ", sequenceName = "FPD_DDS_ENTITY_SEQ",initialValue = 1)

    private Long internalEntityId;

    private String entityId;

    private String entityName;

    private String entityShortName;

    private String primaryContactName;

    private String entityType;

    private String city;

    private String emirate;

    private String postBoxNumber;

    private String telephone;

    private String fax;

    private String primaryContactMobile;

    private String webSiteAddress;

    private String defaultEmailAddress;

    private String maximumAdminstrators;

    private String definedAdministrators;

    private String maximumUsers;

    private String definedUsers;

    private String eis;

    private String address1;

    private String address2;

    private String defaultStpFolderName;

    private String currentAccountNumbers;

    private String transactionAccountNumber;

    private String fa;

    private String usdAccountNumber;

    private String eurAccountNumber;

    private String reserveAccountNumber;

    private String heldAmount;

    private String stSeqNo;

    private String actBranch;

    private String checkBal;
    
    private String micrEntityId;

}
