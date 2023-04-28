package com.api.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.websocket.form.Greeting;
import com.api.websocket.form.HelloMessage;

@Controller
@CrossOrigin
public class GreetingController {

	@MessageMapping("/endpointmessage")
	@SendTo("/topic/mensagens")
	public Greeting greeting(@RequestBody HelloMessage message) throws Exception{
		
		//Thread.sleep(1000);
		
		System.out.println("MENSAGEM RECEBIDA: "+message.getName());
		
		return new Greeting(message.getName());
		
	}
	
}
