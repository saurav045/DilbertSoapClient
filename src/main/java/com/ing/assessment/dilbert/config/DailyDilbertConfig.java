package com.ing.assessment.dilbert.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class DailyDilbertConfig {

	@Value("${dilbert.endpoint}")
	private String dilbertEndpoint;

	@Bean
	Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath("com.ing.assessment.dilbert.stubs");
		return jaxb2Marshaller;
	}

	@Bean
	public DilbertClient dilbertClient(Jaxb2Marshaller marshaller) {
		DilbertClient client = new DilbertClient();
		client.setDefaultUri(dilbertEndpoint);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
