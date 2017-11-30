package br.com.weathercast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
public class Main implements DTO {

	@JsonProperty("temp_min")
	private Double minTemperature;

	@JsonProperty("temp_max")
	private Double maxTemperature;

	@JsonProperty("pressure")
	private Double pressure;

	@JsonProperty("sea_level")
	private Double seaLevel;

	@JsonProperty("temp")
	private Double temperature;

	@JsonProperty("humidity")
	private Double humidity;

	@JsonProperty("grnd_level")
	private Double grnd_level;

	@JsonProperty("temp_kf")
	private Double temp_kf;

	public Main() {
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" Temp: ").append(temperature).append("\n");
		sb.append(" Min: ").append(minTemperature).append("\n");
		sb.append(" M�x: ").append(maxTemperature).append("\n");
		sb.append(" Press�o: ").append(pressure).append("\n");
		sb.append(" Humidade: ").append(humidity).append("\n");

		return sb.toString();
	}

}
