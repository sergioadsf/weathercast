package br.com.weathercast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
public class Wind implements DTO {

	@JsonProperty("speed")
	private Double speed;

	@JsonProperty("deg")
	private Double degrees;

	@JsonProperty("gust")
	private Double gust;

	public Wind() {
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(" Vento:\n");
		sb.append("Velocidade: ").append(speed).append("\n");
		sb.append("Graus: ").append(degrees).append("\n");
		return sb.toString();
	}

}
