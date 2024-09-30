package com.optimagrowth.licensingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optimagrowth.licensingservice.model.License;
import com.optimagrowth.licensingservice.service.LicenseService;


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
	
	@Autowired
	private LicenseService lincenseService;
	
	LicenseController(LicenseService lincenseService){
		
		this.lincenseService = lincenseService;
	}
	
	@GetMapping("/{licenseId}")
	public ResponseEntity<License> getLicense(@PathVariable("organizationId") String organizationId , @PathVariable
			("licenseId") String licenseId){
		
		License license = lincenseService.getLicense(licenseId, organizationId);
		return ResponseEntity.ok(license);
		
	}
	

}
