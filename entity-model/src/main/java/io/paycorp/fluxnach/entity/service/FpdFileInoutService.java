/**
 * 
 */
package io.paycorp.fluxnach.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.paycorp.fluxnach.entity.FpdFileInout;
import io.paycorp.fluxnach.entity.repository.FpdFileInoutRepository;

/**
 * @author nagendrappae
 *
 */
@Service
public class FpdFileInoutService {

	@Autowired
	private FpdFileInoutRepository repo;

	public FpdFileInout getByBatchFileName(String fileName) {
		return repo.findByBatchFileName(fileName);
	}

	public void update(FpdFileInout outwardBatchPayment) {
		repo.save(outwardBatchPayment);
		
	}

	public void save(FpdFileInout outwardBatchPayment) {
		repo.save(outwardBatchPayment);
	}

}
