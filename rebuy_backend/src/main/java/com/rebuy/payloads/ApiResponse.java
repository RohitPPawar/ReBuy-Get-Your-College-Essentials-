package com.rebuy.payloads;

import lombok.Data;

@Data
public class ApiResponse {

	public ApiResponse(String messasge, boolean success) {
		super();
		this.messasge = messasge;
		this.success = success;
	}

	private String messasge;
	private boolean success;

}
