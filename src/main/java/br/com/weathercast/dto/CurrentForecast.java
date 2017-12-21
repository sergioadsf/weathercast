package br.com.weathercast.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentForecast implements DTO {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("cod")
	private Integer code;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("base")
	private String base;

	@JsonProperty("visibility")
	private BigDecimal visibility;
	
	@JsonProperty("wind")
	private Wind wind;
	
	@JsonProperty("weather")
	private List<Weather> weather;

	@JsonProperty("dt")
	private Long date;

	@JsonProperty("main")
	private Main main;

	public CurrentForecast() {
		weather = new ArrayList<>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" Data: ").append(new Date(date)).append("\n");
		sb.append(main).append("\n");
		weather.stream().forEach(System.out::print);
		sb.append(wind).append("\n");
		return sb.toString();
	}

}
