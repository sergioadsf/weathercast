package br.com.weathercast.dto;

@SuppressWarnings("serial")
public class Response<T extends Object> implements DTO {

	private boolean success;

	private String message;

	private T response;

	public Response(Boolean success) {
		this(success, "", null);
	}

	public Response(Boolean success, T objetoRetorno) {
		this(success, "", objetoRetorno);
	}

	public Response(Boolean success, String message) {
		this(success, message, null);
	}

	public Response(Boolean success, String message, T response) {
		super();
		this.success = success;
		this.message = message;
		this.response = response;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public T getResponse() {
		return response;
	}

}
