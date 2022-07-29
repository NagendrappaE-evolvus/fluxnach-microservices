/**
 * 
 */
package io.paycorp.fluxnach.entity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.paycorp.fluxnach.entity.FpdOrg;
import io.paycorp.fluxnach.entity.repository.FpdOrgRepository;

/**
 * @author nagendrappae
 *
 */
@Service
public class FpdOrgService {
	@Autowired
	private FpdOrgRepository repo;

	
	public Optional<FpdOrg> findByOrgOic(String oic) {
		// TODO Auto-generated method stub
		return repo.findByOrgOic(oic);
	}

}
