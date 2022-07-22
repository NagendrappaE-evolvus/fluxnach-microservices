/**
 * 
 */
package io.paycorp.fluxnach.entity.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.paycorp.fluxnach.entity.FpdOrg;

/**
 * @author nagendrappae
 *
 */
@Repository
@Transactional
public interface FpdOrgRepository extends CrudRepository<FpdOrg, Long> {

}
