/**
 * 
 */
package io.paycorp.fluxnach.outwardpaymentserver.processor;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author nagendrappae
 *
 */
@Component
@Slf4j
public class FileUploadProcessor implements Processor {

	private ArrayList<String> errorMsgList;

	@Override
	public void process(Exchange exchange) throws Exception {
		
		System.out.println("hiiii");
		/*
		 * errorMsgList = new ArrayList<>(); try { List<F> payList =
		 * (List<OutwardPayment>) exchange .getIn().getBody(); OutwardBatchPayment
		 * outwardBatchPayment = (OutwardBatchPayment) exchange
		 * .getIn().getHeader("outwardBatchPayment"); fileName = (String)
		 * exchange.getIn().getHeader("CamelFileName"); msgType =
		 * fileName.split("~")[0]; getRecordReferenceNumber(payList); String oic =
		 * outwardBatchPayment.getParam10(); getMandate(payList, oic, msgType,
		 * outwardBatchPayment); } catch (Exception e) {
		 * LOG.debug("Exception ::::{}",ExceptionUtils.getFullStackTrace(e)); }
		 * 
		 */}

}
