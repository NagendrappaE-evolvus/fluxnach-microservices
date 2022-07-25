/**
 * 
 */
package io.paycorp.fluxnach.commonservice;

import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.stereotype.Service;

import io.paycorp.fluxnach.entity.service.FpdSeqNumberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author nagendrappae
 *
 */
//@Service
@Data
@Slf4j
@AllArgsConstructor
public class GenericReferenceService {
	/**
	 * Declared variable lineAggregator of
	 * LineAggregator<GenericReferenceServiceImpl>.
	 */
	
	
	/*
	 * public GenericReferenceService() { }
	 */
	private LineAggregator<GenericReferenceService> lineAggregator;
	/**
	 * Declared variable msgFormat.
	 */
	private String msgFormat;
	/**
	 * Declared variable msgID.
	 */
	private String msgID;
	/**
	 * Declared variable entityID.
	 */
	private String entityID;
	/**
	 * Declared variable date.
	 */

	private String date;
	/**
	 * Declared variable time.
	 */
	private String time;
	/**
	 * Declared variable seqValue.
	 */
	private String seqValue;
	/**
	 * Declared variable fixedValue.
	 */
	private String fixedValue;
	/**
	 * Declared variable seqNumberService.
	 */
	
	private FpdSeqNumberService seqNumberService;

	private String fileDate;
	private String transType;
	private String npciUserName;
	private String mandateIndentifier;
	
	/*
	 * public GenericReferenceService(FpdSeqNumberService seqNumberService) {
	 * super(); this.seqNumberService = seqNumberService; }
	 */
	
	public String getNextReference() {
		try {
			seqValue = seqNumberService.generateNewSeqValue(1, true);
		} catch (Exception e) {
			log.error("{}", e);
		}
		return lineAggregator.aggregate(this);

	}
}
