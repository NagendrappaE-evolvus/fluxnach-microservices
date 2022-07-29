/**
 * 
 */
package io.paycorp.fluxnach.entity.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.paycorp.fluxnach.entity.FpdMandateMaster;

/**
 * @author nagendrappae
 *
 */
@Repository
@Transactional
public interface FpdMandateMasterRepository extends CrudRepository<FpdMandateMaster, Long> {

	FpdMandateMaster findByUmrnAndMndStatus(String umrn, String mndSts);

}
