/**
 * 
 */
package io.paycorp.fluxnach.entity.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.paycorp.fluxnach.entity.FpdReasonCode;

/**
 * @author nagendrappae
 *
 */
@Repository
@Transactional
public interface FpdReasonCodeRepository extends CrudRepository<FpdReasonCode, Long> {

	Optional<FpdReasonCode> findByRsnCode(String errorNum);

}
