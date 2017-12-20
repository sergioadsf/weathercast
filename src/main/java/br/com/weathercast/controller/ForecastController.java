package br.com.weathercast.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.weathercast.ForecastType;
import br.com.weathercast.WUrl;
import br.com.weathercast.dto.Forecast;

@RestController
@RequestMapping("forecast")
public class ForecastController extends WeatherController {

	@ResponseBody
	@GetMapping(path = "/test")
	public Forecast getNome() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream asStream = ForecastController.class.getResourceAsStream("/weathercast.json");
		Forecast clima = mapper.readValue(asStream, Forecast.class);
		return clima;
	}

	@ResponseBody
	@GetMapping(path = "/cidade/{nome}")
	public Forecast cidade(@PathVariable("nome") String nomeCidade)
			throws JsonParseException, JsonMappingException, IOException {
		try {
			ObjectMapper mapper = new ObjectMapper();
//			InputStream asStream = ForecastController.class.getResourceAsStream("/weathercast.json");
			String json = WUrl.start(ForecastType.FORECAST, config.getUrl(), config.getApiKey()).cidade(nomeCidade).search();
			Forecast clima = mapper.readValue(json, Forecast.class);
			return clima;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@ResponseBody
	@PostMapping(path = "/test/{id}")
	public Forecast add(@PathVariable long id) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream asStream = ForecastController.class.getResourceAsStream("/weathercast.json");
		Forecast clima = mapper.readValue(asStream, Forecast.class);
		return clima;
	}
}
