package br.com.weathercast;

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
		}
		
		public WQuery cidade(String nome) {
			query.append(Q).append(nome);
			return this;
		}

		public String get() {
			return query.toString();
		}

	}

}
