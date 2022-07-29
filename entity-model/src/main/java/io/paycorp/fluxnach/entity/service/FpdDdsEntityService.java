/**
 * 
 */
package io.paycorp.fluxnach.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.paycorp.fluxnach.entity.FpdDdsEntity;
import io.paycorp.fluxnach.entity.repository.FpdDdsEntityRepository;

/**
 * @author nagendrappae
 *
 */
@Service
public class FpdDdsEntityService {

	@Autowired
	private FpdDdsEntityRepository repo;

	public List<FpdDdsEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<FpdDdsEntity>) repo.findAll();
	}
	
	
}
