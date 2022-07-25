/**
 * 
 */
package io.paycorp.fluxnach;

import java.util.ArrayList;

import org.apache.camel.component.file.AntPathMatcherGenericFileFilter;
import org.apache.camel.component.file.GenericFileFilter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.FormatterLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import io.paycorp.fluxnach.commonservice.GenericReferenceService;
import io.paycorp.fluxnach.entity.service.FpdFileInoutService;
import io.paycorp.fluxnach.entity.service.FpdSeqNumberService;
import io.paycorp.fluxnach.outwardpaymentserver.processor.PreProcessor;

/**
 * @author nagendrappae
 *
 */
@Configuration
public class OutwardPaymentConfiguration {

	private static final String orgdruploadInclude = "ORGDR*.CSV, ORGDR*.csv";

	@Bean
	public PreProcessor preProcessor(@Value("${localErrorFolder}") String path, ArrayList<String> errorMsgList,
			@Qualifier("FILE_INOUT_BATCH_SeqNumber") GenericReferenceService genericReferenceService,
			@Autowired FpdFileInoutService fpdFileInoutService,
			@Value("file:///${filepath}/APP_FILES/ach-originator-upload-config.xml") Resource rs) {

		String fileErrName = null;
		String fileStatus = null;
		String msgType = null;

		return new PreProcessor(path, fileErrName, "ACHORG_Upload", fileStatus, msgType, errorMsgList,
				genericReferenceService, fpdFileInoutService, rs);

	}

	@Bean("orgdrFilter")
	public GenericFileFilter orgdrFilter() {

		AntPathMatcherGenericFileFilter filter = new AntPathMatcherGenericFileFilter();
		filter.setIncludes(orgdruploadInclude);
		// filter.setExcludes(orgdruploadInclude);
		// filter.sete

		return filter;

	}

	@Bean
	public FormatterLineAggregator fiobatchflineagregator(
			@Qualifier("fiobatchfextrarctor") BeanWrapperFieldExtractor fiobatchfextrarctor) {
		FormatterLineAggregator formatterLineAggregator = new FormatterLineAggregator();
		formatterLineAggregator.setFormat("%1$s%2$s");
		formatterLineAggregator.setFieldExtractor(fiobatchfextrarctor);
		return formatterLineAggregator;

	}

	@Bean
	public BeanWrapperFieldExtractor fiobatchfextrarctor() {
		BeanWrapperFieldExtractor beanWrapperFieldExtractor = new BeanWrapperFieldExtractor();
		beanWrapperFieldExtractor.setNames(new String[] { "date", "seqValue" });
		return beanWrapperFieldExtractor;

	}

	@Bean
	public FpdSeqNumberService fiobatchSeqNumberService() {

		return new FpdSeqNumberService("OUT_BATCH_REF_NUM", "6", "0");

	}

	@Bean
	public GenericReferenceService FILE_INOUT_BATCH_SeqNumber(
			@Qualifier("fiobatchSeqNumberService") FpdSeqNumberService fpdSeqNumberService,@Qualifier("fiobatchflineagregator")FormatterLineAggregator formatterLineAggregator  ) {
		return new GenericReferenceService(formatterLineAggregator, "", null, null, "date", null, null, null, fpdSeqNumberService, null, null, null, null);

	}

}
