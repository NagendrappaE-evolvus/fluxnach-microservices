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
	private FpdFileInoutRepository ffirepo;

	public FpdFileInout getByBatchFileName(String fileName) {
		return ffirepo.findByBatchFileName(fileName);
	}

	public void update(FpdFileInout outwardBatchPayment) {
		ffirepo.save(outwardBatchPayment);
		
	}

	public void save(FpdFileInout outwardBatchPayment) {
		ffirepo.save(outwardBatchPayment);
	}

}
