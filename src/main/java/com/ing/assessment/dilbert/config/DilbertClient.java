package com.ing.assessment.dilbert.config;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.ing.assessment.dilbert.stubs.DailyDilbert;
import com.ing.assessment.dilbert.stubs.DailyDilbertResponse;

public class DilbertClient extends WebServiceGatewaySupport {
	
	@Value("${dilbert.endpoint}")
	private String dilbertEndpoint;
	
	@Value("${dilbert.soap.action}")
	private String dilbertSoapAction;
	
	public DailyDilbertResponse getDailyDilbert(Date date) throws DatatypeConfigurationException {
		DailyDilbert request = new DailyDilbert();
		request.setADate(convertToXMLGregorian(date));
		DailyDilbertResponse response = (DailyDilbertResponse) getWebServiceTemplate()
				.marshalSendAndReceive(dilbertEndpoint, request, new SoapActionCallback(dilbertSoapAction));
		return response;
	}

	private XMLGregorianCalendar convertToXMLGregorian(Date date) throws DatatypeConfigurationException {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(date);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
	}
}
