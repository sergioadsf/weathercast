package br.com.weathercast.service;

import br.com.weathercast.ForecastType;
import br.com.weathercast.WeatherParams;

public class WUrl extends WeatherParams {

	private static WQuery wquery;

	public static final WQuery start(ForecastType type, String url, String token) {
		wquery = new WUrl().new WQuery(type, url, token);
		return wquery;
	}

	public class WQuery {

		private final StringBuilder query;

		private WQuery(ForecastType type, String url, String token) {
			query = new StringBuilder(url);
			query.append(type.getType());
			query.append(ID);
			query.append(API_KEY).append(token);
			query.append(LANG).append("pt");
			query.append(UNITS).append("metric");
		}

		public WQuery cidade(String nome) {
			query.append(Q).append(nome).append(",br");
			return this;
		}

		public WQuery dias(int dias) {
			query.append(CNT).append(dias);
			return this;
		}

		public String search() throws Exception {
			return HttpSearch.executeGet(query.toString());
		}

	}

}
