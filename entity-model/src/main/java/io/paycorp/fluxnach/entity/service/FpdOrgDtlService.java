/**
 * 
 */
package io.paycorp.fluxnach.entity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.paycorp.fluxnach.entity.FpdOrgDtl;
import io.paycorp.fluxnach.entity.repository.FpdOrgDtlRepository;

/**
 * @author nagendrappae
 *
 */
@Service
public class FpdOrgDtlService {

	@Autowired
	public FpdOrgDtlRepository repo;

	public Optional<FpdOrgDtl> findByOrgRefNo(String orgRefNo) {

		return repo.findByOrgRefNo(orgRefNo);
	}

}
