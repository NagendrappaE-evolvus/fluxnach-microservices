/**
 * 
 */
package io.paycorp.fluxnach.entity.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.paycorp.fluxnach.entity.FpdFileInout;

/**
 * @author nagendrappae
 *
 */
@Repository
@Transactional
public interface FpdFileInoutRepository extends CrudRepository<FpdFileInout, Long> {

	public FpdFileInout findByBatchFileName(String batchFileName);
}
