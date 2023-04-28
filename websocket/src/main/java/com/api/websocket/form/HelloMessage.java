package com.api.websocket.form;

import com.fasterxml.jackson.annotation.JsonCreator;

public class HelloMessage {
	
	private String name;

	@JsonCreator
	public HelloMessage(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
