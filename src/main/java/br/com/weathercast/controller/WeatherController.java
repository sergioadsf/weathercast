package br.com.weathercast.controller;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.weathercast.config.WeatherConfig;

public class WeatherController {

	@Autowired
	protected WeatherConfig config;
	
}
