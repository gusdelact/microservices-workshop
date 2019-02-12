package com.gfi.microservicios.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/dummy")

public class MicroServicioController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@RequestMapping(value="mensaje",method = RequestMethod.GET)
	public String mensaje() {
		logger.debug("dummy mensaje invocado");
		
		return "un mensaje dummy";
	}

	@RequestMapping(value="saludo",method = RequestMethod.GET)
	public String saludo() {
		logger.debug("dummy saludo invocado");
		randomlyRunLong();
		return "que hay de nuevo microservicio!";
	}


	private void randomlyRunLong() {
		Random rand = new Random();

		int randomNum = rand.nextInt((3 - 1) + 1) + 1;

		if (randomNum==3) sleep();
	}
	private void sleep(){
		logger.debug("sleep invocado");
		try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.debug("sleep despertando");
	}
}
