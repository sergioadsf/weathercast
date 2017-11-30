package br.com.weathercast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
public class Weather implements DTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("main")
	private String main;

	@JsonProperty("description")
	private String description;

	@JsonProperty("icon")
	private String icon;

	public Weather() {
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" Titulo: ").append(main).append("\n");
		sb.append(" Desc: ").append(description).append("\n");
		sb.append(" Icone: ").append(icon).append("\n");
		return sb.toString();
	}

}
