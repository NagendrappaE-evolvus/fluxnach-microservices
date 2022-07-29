/**
 * 
 */
package io.paycorp.fluxnach.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.paycorp.fluxnach.entity.FpdFileErr;
import io.paycorp.fluxnach.entity.repository.FpdFileErrRepository;

/**
 * @author nagendrappae
 *
 */
@Service
public class FpdFileErrService {
	
	@Autowired
	public FpdFileErrRepository repo;

	public  void save(FpdFileErr fileErr) {
		// TODO Auto-generated method stub
		
		repo.save(fileErr);
		
	}

}
