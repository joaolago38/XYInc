package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Poi;
import com.example.demo.repositoriy.PoiRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PoinEndpointTests {

	@Autowired
	private PoiRepository poiRepository;

	private RestTemplate restTemplate;

	// URL base para onde as requests serão feitas
	final String BASE_PATH = "http://localhost:8080/v1/poi";

	private ObjectMapper MAPPER = new ObjectMapper();

	// Definimos o que será feito antes da execução do teste
	@Before
	public void setUp() throws Exception {

		poiRepository.deleteAll();
		Poi poi = new Poi(1, "quintada do senhor Jose", 23, 45);
		this.poiRepository.save(poi);
		restTemplate = new RestTemplate();

	}

	@Test
	public void testPostPoi() throws JsonProcessingException {
		Poi poi = new Poi(1, "quintada do senhor Jose", 23, 45);
		Poi response = restTemplate.postForObject(BASE_PATH, poi, Poi.class);
		Assert.assertEquals("quintada do senhor Jose", response.getNomeDoPoi());

	}


}
