package io.paycorp.fluxnach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource({ "classpath*:generate-reference-config.xml" })
public class OutwardPaymentServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutwardPaymentServerApplication.class, args);
	}

}
