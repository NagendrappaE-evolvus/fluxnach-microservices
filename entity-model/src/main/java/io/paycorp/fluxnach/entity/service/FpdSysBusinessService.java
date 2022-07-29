/**
 * 
 */
package io.paycorp.fluxnach.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.paycorp.fluxnach.entity.FpdSysBusiness;
import io.paycorp.fluxnach.entity.repository.FpdSysBusinessRepository;

/**
 * @author nagendrappae
 *
 */
@Service
public class FpdSysBusinessService {

	@Autowired
	public FpdSysBusinessRepository repo;
	public List<FpdSysBusiness> findAll() {
		// TODO Auto-generated method stub
		return (List<FpdSysBusiness>) repo.findAll();
	}

}
