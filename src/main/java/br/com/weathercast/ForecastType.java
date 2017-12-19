package br.com.weathercast;

public enum ForecastType {
	CURRENT("weather"), FORECAST("forecast"), DAILY("forecast/daily");

	private ForecastType(String type) {
		this.type = type;
	}

	private String type;

	public String getType() {
		return type;
	}

}
