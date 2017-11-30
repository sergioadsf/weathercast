package br.com.weathercast.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.weathercast.dto.Forecast;

@RestController
@RequestMapping("forecast")
public class ForecastController {

	@ResponseBody
	@GetMapping(path = "/test")
	public Forecast getNome() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream asStream = ForecastController.class.getResourceAsStream("/weathercast.json");
		Forecast clima = mapper.readValue(asStream, Forecast.class);
		return clima;
	}
}
