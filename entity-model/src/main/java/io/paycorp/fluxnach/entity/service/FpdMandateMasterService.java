/**
 * 
 */
package io.paycorp.fluxnach.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.paycorp.fluxnach.entity.FpdMandateMaster;
import io.paycorp.fluxnach.entity.repository.FpdMandateMasterRepository;

/**
 * @author nagendrappae
 *
 */
@Service
public class FpdMandateMasterService {

	@Autowired
	public FpdMandateMasterRepository repo;
	
	public FpdMandateMaster findByUmrnAndMndStatus(String umrn, String mndSts) {
		// TODO Auto-generated method stub
		return repo.findByUmrnAndMndStatus(umrn,mndSts);
	}

}
