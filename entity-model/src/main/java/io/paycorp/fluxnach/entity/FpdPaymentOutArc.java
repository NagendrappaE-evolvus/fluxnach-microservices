/**
 * 
 */
package io.paycorp.fluxnach.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author nagendrappae
 *
 */
@Entity 
@Data
public class FpdPaymentOutArc {

	@Id
	private Long payRef;
}
