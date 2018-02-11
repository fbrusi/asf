package br.com.asf.service.bean;

public class ResponseMessage {

	private int code;
	
	private String message;
	
	public ResponseMessage() {
		
		this.code = 0;
		this.message = "Operação realizada com sucesso!";
	}
	
	public ResponseMessage(String message) {
		
		this.code = -1;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
