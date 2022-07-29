/**
 * 
 */
package io.paycorp.fluxnach.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.paycorp.fluxnach.entity.FpdSeqNumber;
import io.paycorp.fluxnach.entity.id.generator.AlphanumericGenerator;
import io.paycorp.fluxnach.entity.repository.FpdSeqNumberRepository;

/**
 * @author nagendrappae
 *
 */
@Service
public class FpdSeqNumberService {
	@Autowired
	private FpdSeqNumberRepository fpsrepo;
	
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
	

	public String generateNewSeqValue(int blockVal, boolean updateFlag) {
		
		synchronized (seqCode) {
			String firstSeq="";
			String finalSeq="";
			FpdSeqNumber seqNumber = fpsrepo.findBySeqCode(seqCode);
			AlphanumericGenerator alphanumericGenerator = new AlphanumericGenerator(
					true, seqNumber.getSeqValue());
			if ("AN".equals(seqNumber.getSeqType())) {
				firstSeq = alphanumericGenerator.nextStringIdentifier();
				finalSeq=firstSeq;
				for (int i = 2; i <= blockVal; i++) {
					finalSeq=alphanumericGenerator.nextStringIdentifier();
					
				}

			} else if ("N".equals(seqNumber.getSeqType())) {
				firstSeq = alphanumericGenerator.nextNumericIdentifier();
				finalSeq=firstSeq;
			}
			seqNumber.setSeqValue(finalSeq);
			if (updateFlag) 
				fpsrepo.save(seqNumber);
			firstSeq = this.leftPad(firstSeq,
					Integer.valueOf(seqPadSize), seqPadChar.charAt(0));
			return firstSeq;
		}
	}

	public String leftPad(String input,  int L,char ch) {

		String result = String

				// First left pad the string
				// with space up to length L
				.format("%" + L + "s", input)

				// Then replace all the spaces
				// with the given character ch
				.replace(' ', ch);

		// Return the resultant string
		return result;
	}
	
	public String rightPadding(String input, char ch, int L) {

		String result = String

				// First right pad the string
				// with space up to length L
				.format("%" + (-L) + "s", input)

				// Then replace all the spaces
				// with the given character ch
				.replace(' ', ch);

		// Return the resultant string
		return result;
	}


	public String generateNewSeqValue(String seqValue, int blockVal, String seqType) {
		synchronized (seqCode) {
			String finalSeq="";
			AlphanumericGenerator alphanumericGenerator = new AlphanumericGenerator(
					true, seqValue);
			if ("AN".equals(seqType)){
				finalSeq = alphanumericGenerator.nextStringIdentifier();
				for (int i = 2; i <= blockVal; i++) {
					finalSeq=alphanumericGenerator.nextStringIdentifier();
					
				}

			} else if ("N".equals(seqType)) {
				finalSeq = alphanumericGenerator.nextStringIdentifier();
			}
			finalSeq = this.leftPad(finalSeq,
					Integer.valueOf(seqPadSize), seqPadChar.charAt(0));
			return finalSeq;
		}
	}
}
