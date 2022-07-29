/**
 * 
 */
package io.paycorp.fluxnach.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.paycorp.fluxnach.entity.FpdPaymentOut;
import io.paycorp.fluxnach.entity.repository.FpdPaymentOutRepository;

/**
 * @author nagendrappae
 *
 */
@Service
public class FpdPaymentOutService {
	
	@Autowired
	public FpdPaymentOutRepository repo;

	public void save(FpdPaymentOut payment) {
		repo.save(payment);		
	}

}
