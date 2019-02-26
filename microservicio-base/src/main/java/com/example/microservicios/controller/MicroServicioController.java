package com.example.microservicios.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicios.client.DummyOAuth2RestTemplateClient;
import com.example.microservicios.eventlog.EventLogEntry;
import com.example.microservicios.eventlog.EventLogService;





@RestController
@RequestMapping(value = "/microservicio")

public class MicroServicioController {
		

	@Autowired
	private DummyOAuth2RestTemplateClient dummyOAuth2RestTemplateClient; 
	
	@Autowired
	private EventLogService eventLogService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="",method = RequestMethod.GET)
	public String metodo() {
		return "una cadena de un microservicio registrado con Eureka";
	}
	
 
	@RequestMapping(value="/marco", method = RequestMethod.GET)
	public String noDummy(){
		logger.debug("marco polo");
		return "polo";
	}
	
	@RequestMapping(value="/event", method = RequestMethod.POST, consumes= {"application/json"})
	public void event(Tweet tweet) {
		
		EventLogEntry entry = new EventLogEntry("Tweet text: " + tweet.getText());
		// Publish event
		eventLogService.send(entry);
		
		
	}	
	
	@RequestMapping(value="/v3/mensaje",method = RequestMethod.GET)
	public String metodoDummyMensajev3() {
		String resultado= "hola dummy saludo";
		resultado=dummyOAuth2RestTemplateClient.getMensaje();
		if (resultado==null) resultado= "hola dummy mensaje por omision";
		logger.debug(resultado);
		eventLogService.send(new EventLogEntry("GET Mensaje : "+resultado));	
		return resultado;
	}
	
	@RequestMapping(value="/v3/saludo",method = RequestMethod.GET)
	public String metodoDummySaludov3() {
		String resultado= "hola dummy saludo";
		resultado=dummyOAuth2RestTemplateClient.getSaludo();
		if (resultado==null) resultado= "hola dummy saludo por omision";
		logger.debug(resultado);
		return resultado;
	}
	

}
