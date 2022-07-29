/**
 * 
 */
package io.paycorp.fluxnach.entity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.paycorp.fluxnach.entity.FpdReasonCode;
import io.paycorp.fluxnach.entity.repository.FpdReasonCodeRepository;

/**
 * @author nagendrappae
 *
 */
@Service
public class FpdReasonCodeService {

	@Autowired
	public FpdReasonCodeRepository repo;
	
	public Optional<FpdReasonCode> findByRsnCode(String errorNum) {
		// TODO Auto-generated method stub
		return repo.findByRsnCode(errorNum);
	}

}
