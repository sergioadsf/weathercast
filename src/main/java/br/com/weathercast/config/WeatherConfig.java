package br.com.weathercast.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfig {

	@Value("${api.url}")
	private String url;

	@Value("${api.key}")
	private String apiKey;

	public String getApiKey() {
		return apiKey;
	}

	public String getUrl() {
		return url;
	}

}
