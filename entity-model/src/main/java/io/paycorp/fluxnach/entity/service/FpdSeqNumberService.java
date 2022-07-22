/**
 * 
 */
package io.paycorp.fluxnach.entity.service;

import org.springframework.stereotype.Service;

/**
 * @author nagendrappae
 *
 */
@Service
public class FpdSeqNumberService {
	public FpdSeqNumberService(String seqCode, String seqPadSize, String seqPadChar) {
		super();
		this.seqCode = seqCode;
		this.seqPadSize = seqPadSize;
		this.seqPadChar = seqPadChar;
	}


	private String seqCode;
	private String seqPadSize;
	private String seqPadChar;

	public FpdSeqNumberService() {
	}
	

	public String generateNewSeqValue(int i, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

}
