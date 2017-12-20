package br.com.weathercast.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@JsonIgnoreProperties({ "" })
public class City implements DTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("country")
	private String country;

	@JsonProperty("population")
	private BigDecimal population;

	@JsonProperty("coord")
	private Coordinates coordinate;

	public City() {
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("****** Cidade ******\n");
		sb.append(" ID:		").append(id).append("\n");
		sb.append(" Nome:		").append(name).append("\n");
		sb.append(" País:		").append(country).append("\n");
		sb.append(coordinate);
		return sb.toString();
	}
}
