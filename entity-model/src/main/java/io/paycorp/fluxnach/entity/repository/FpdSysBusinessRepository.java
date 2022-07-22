/**
 * 
 */
package io.paycorp.fluxnach.entity.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.paycorp.fluxnach.entity.FpdSysBusiness;

/**
 * @author nagendrappae
 *
 */
@Repository
@Transactional
public interface FpdSysBusinessRepository extends CrudRepository<FpdSysBusiness, Long>{

}
