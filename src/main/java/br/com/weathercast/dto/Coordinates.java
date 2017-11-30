package br.com.weathercast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
public class Coordinates implements DTO  {

	@JsonProperty("lat")
	private Double latitude;

	@JsonProperty("lon")
	private Double longitude;

	public Coordinates() {
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(" ****** Coordenadas ******\n");
		sb.append(" Lat:		").append(latitude).append("\n");
		sb.append(" Long:		").append(longitude).append("\n");
		return sb.toString();
	}

}
