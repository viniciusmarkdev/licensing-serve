package com.optimagrowth.licensingservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * informa ao Spring Boot que este é um serviço baseado em REST e que ele irá automaticamente serializar/deserializar 
 * as requisições/respostas do serviço via JSON.
 */
@RestController
/*
 * Exponde todos os endpoints HTTP nesta classe com o
 *  prefixo /v1/organization/{organizationId}/license.
 */
@RequestMapping(value="v1/organization/{organizationId}/license")
public class LicenseController {
	
	
	
	

}
