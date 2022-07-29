/**
 * 
 */
package io.paycorp.fluxnach.entity.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.paycorp.fluxnach.entity.FpdOrgDtl;

/**
 * @author nagendrappae
 *
 */
@Repository
@Transactional
public interface FpdOrgDtlRepository extends CrudRepository<FpdOrgDtl, Long>{

	Optional<FpdOrgDtl> findByOrgRefNo(String orgRefNo);

}
