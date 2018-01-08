package br.com.weathercast.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.weathercast.config.WeatherConfig;
import br.com.weathercast.dto.Response;

public class BaseController {

	@Autowired
	protected WeatherConfig config;

	protected <T extends Object> Response<T>enviarSucesso() {

		return new Response<T>(true);
	}

	protected <T extends Object> Response<T>fail(String msg) {

		return new Response<T>(false, msg);
	}

	protected <T extends Object> Response<T>success(T objetoRetorno) {

		return new Response<T>(true, objetoRetorno);
	}

	protected <T extends Object> Response<T>success() {

		return new Response<T>(true, "");
	}

	protected <T extends Object> T convert(Class<T> clazz, String json)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, clazz);
	}
}
