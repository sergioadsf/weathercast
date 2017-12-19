package br.com.weathercast.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfig {

	@Value("${api.url}")
	private String url;

	@Value("${api.key}")
	public String API_KEY;

	public String getApiKey() {
		return System.getenv(API_KEY);
	}

	public String getUrl() {
		return url;
	}

}
