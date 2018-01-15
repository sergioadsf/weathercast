package br.com.weathercast.controller;

import java.io.FileNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.weathercast.ForecastType;
import br.com.weathercast.dto.Forecast;
import br.com.weathercast.dto.Response;
import br.com.weathercast.service.WUrl;

@RestController
@RequestMapping("forecast5")
public class Forecast5Controller extends BaseController {

	@ResponseBody
	@GetMapping(path = "/cidade/{nome}")
	public Response<Forecast> cidade(@PathVariable("nome") String nomeCidade) {
		try {
			String json = WUrl.start(ForecastType.FORECAST, config.getUrl(), config.getApiKey()).cidade(nomeCidade)
					.search();
			Forecast current = convert(Forecast.class, json);
			return success(current);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof FileNotFoundException) {
				return fail("Infelizmente ainda não conheço a cidade de " + nomeCidade + " !");
			}

			return fail("Não foi possivel consultar a cidade de " + nomeCidade);
		}

	}
}
