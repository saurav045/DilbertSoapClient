package com.ing.assessment.dilbert.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DailyDilbertControllerTest {

	@Autowired
	DailyDilbertController dilbertController;

	@Test(expected = NullPointerException.class)
	public void dailyDilbert_whenNoDateProvided() throws DatatypeConfigurationException {
		dilbertController.dailyDilbert(null);
	}

	@Test
	public void dailyDilbert_whenDateProvided() throws DatatypeConfigurationException {
		String response = dilbertController.dailyDilbert(new Date());
		assertNotNull(response);
	}

}
