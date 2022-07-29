/**
 * 
 */
package io.paycorp.fluxnach.commonservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.batch.item.file.transform.LineAggregator;

import io.paycorp.fluxnach.entity.FpdDdsEntity;
import io.paycorp.fluxnach.entity.FpdSysBusiness;
import io.paycorp.fluxnach.entity.service.FpdDdsEntityService;
import io.paycorp.fluxnach.entity.service.FpdSeqNumberService;
import io.paycorp.fluxnach.entity.service.FpdSysBusinessService;
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
private FpdDdsEntityService fpdDdsEntityService;
	
	private FpdSysBusinessService fpdSysBusinessService; 
	
	public void setEntityID(String entityID) {
		List<FpdDdsEntity> ddsEntityList = fpdDdsEntityService.findAll();
		FpdDdsEntity ddsEntity = ddsEntityList.get(0);
		this.entityID = ddsEntity.getEntityShortName();
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		List<FpdSysBusiness> sysBusinessList = fpdSysBusinessService.findAll();
		FpdSysBusiness sysBus = sysBusinessList.get(0);
		DateFormat df = new SimpleDateFormat("yyMMdd");
		Date dt = sysBus.getCurBusinessDt();
		return df.format(dt);
	}
	
	
	public String getNextReference() {
		try {
			seqValue = seqNumberService.generateNewSeqValue(1, true);
		} catch (Exception e) {
			log.error("{}", e);
		}
		return lineAggregator.aggregate(this);

	}

	public String getNextBlockReference(int size) {
		try {
			seqValue = seqNumberService.generateNewSeqValue(size, true);
		} catch (Exception e) {
			log.error("{}", e);
		}

		return seqValue;
	}

	public String[] getNextJumpReference(String seqValue, int nextVal,
			String seqType) {
		String[] seqArray = new String[2];
		try {
			setSeqValue(seqValue);
			if (nextVal > 0) {
				seqValue = seqNumberService.generateNewSeqValue(seqValue,
						nextVal, seqType);
				setSeqValue(seqValue);
			}
		} catch (Exception e) {
			log.error("{}", e);
		}
		seqArray[0] = lineAggregator.aggregate(this);
		seqArray[1] = seqValue;
		return seqArray;
	}
}
