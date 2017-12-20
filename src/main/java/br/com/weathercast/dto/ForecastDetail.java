package br.com.weathercast.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@JsonIgnoreProperties({ "clouds", "rain", "sys", "snow" })
public class ForecastDetail implements DTO {

	@JsonProperty("dt")
	private Long date;

	@JsonProperty("dt_txt")
	private String dateStr;

	@JsonProperty("weather")
	private List<Weather> weather;

	@JsonProperty("main")
	private Main main;

	@JsonProperty("wind")
	private Wind wind;

	public ForecastDetail() {
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
