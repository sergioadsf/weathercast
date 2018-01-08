package br.com.weathercast.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.weathercast.ForecastType;
import br.com.weathercast.dto.CurrentForecast;
import br.com.weathercast.dto.Forecast;
import br.com.weathercast.dto.Response;
import br.com.weathercast.service.WUrl;

@RestController
@RequestMapping("forecast")
public class ForecastController extends BaseController {

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
	public Response<CurrentForecast> cidade(@PathVariable("nome") String nomeCidade) {
		try {
			String json = WUrl.start(ForecastType.CURRENT, config.getUrl(), config.getApiKey()).cidade(nomeCidade)
					.search();
			CurrentForecast current = convert(CurrentForecast.class, json);
			return success(current);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof FileNotFoundException) {
				return fail("Infelizmente ainda não conheço a cidade de " + nomeCidade + " !");
			}

			return fail("Não foi possivel consultar a cidade de " + nomeCidade);
		}

	}

	@ResponseBody
	@PostMapping(path = "/location/")
	public Response<CurrentForecast> localizacao(@RequestBody String location) {
		try {
			String json = WUrl.start(ForecastType.CURRENT, config.getUrl(), config.getApiKey()).point(location)
					.search();
			CurrentForecast current = convert(CurrentForecast.class, json);
			return success(current);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof FileNotFoundException) {
				return fail("Infelizmente ainda não conheço essa localização " + location + " !");
			}
			
			return fail("Não foi possivel consultar a localização " + location);
		}
		
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
