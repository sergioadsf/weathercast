package br.com.weathercast.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@JsonIgnoreProperties({})
public class Forecast implements DTO {

	@JsonProperty("cod")
	private String code;

	@JsonProperty("message")
	private Double msgCode;

	@JsonProperty("cnt")
	private Integer cnt;

	@JsonProperty("city")
	private City city;

	@JsonProperty("list")
	private List<ForecastDetail> listForecast;

	public Forecast() {
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("//************************//\n");
		sb.append("Valores:\n");
		sb.append(" Codigo:	").append(code).append("\n");
		sb.append(" Mensagem:	").append(msgCode).append("\n");
		sb.append(" CNT: 		").append(cnt).append("\n");
		sb.append(city);
		listForecast.stream().forEach(System.out::print);
		sb.append("//************************//");
		return sb.toString();
	}

}
