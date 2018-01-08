package br.com.weathercast.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

import br.com.weathercast.config.ProxyConfig;

public class HttpSearch {

	public static final String executeGet(String url) throws Exception {
		URL target = new URL(url);

		HttpURLConnection connection = initConnection(target);
		connection.setRequestMethod("GET");

		return inputStreamToString(connection.getInputStream());
	}

	private static final HttpURLConnection initConnection(URL target) throws IOException {
		Proxy proxy = ProxyConfig.get();
		if (proxy != null) {
			return (HttpURLConnection) target.openConnection(proxy);
		}

		return (HttpURLConnection) target.openConnection();

	}

	public static final String inputStreamToString(InputStream is) throws Exception {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = is.read(buffer)) != -1) {
			result.write(buffer, 0, length);
		}

		return result.toString("UTF-8");
	}

}
