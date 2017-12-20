package br.com.weathercast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpSearch {

	public final static String executeGet(String url) throws Exception {
		URL target = new URL(url);
		
		HttpURLConnection connection = (HttpURLConnection) target.openConnection();
		connection.setRequestMethod("GET");
		
		connection.getInputStream();
		return inputStreamToString(connection.getInputStream());
	}
	
	public static String inputStreamToString(InputStream is) throws Exception {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = is.read(buffer)) != -1) {
			result.write(buffer, 0, length);
		}

		return result.toString("UTF-8");
	}

}
