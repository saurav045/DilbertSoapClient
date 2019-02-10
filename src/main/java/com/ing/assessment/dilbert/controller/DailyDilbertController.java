package com.ing.assessment.dilbert.controller;

import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.assessment.dilbert.config.DilbertClient;
import com.ing.assessment.dilbert.stubs.DailyDilbertResponse;

@RestController
@RequestMapping("/dilbert")
public class DailyDilbertController {

	@Autowired
	private DilbertClient dilbertClient;
	
	@GetMapping(value = "/daily")
	public String dailyDilbert(@RequestParam(required=true) @DateTimeFormat(pattern = "dd.MM.yyyy") Date date) throws DatatypeConfigurationException {
		DailyDilbertResponse dailyDilbert = dilbertClient.getDailyDilbert(date);
		return "Response Received :: "+dailyDilbert.getDailyDilbertResult();
	}

}
