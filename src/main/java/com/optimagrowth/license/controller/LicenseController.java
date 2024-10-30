package com.optimagrowth.license.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optimagrowth.license.model.License;
import com.optimagrowth.license.service.LicenseService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/*
 * informa ao Spring Boot que este é um serviço baseado em REST e que ele irá automaticamente serializar/deserializar 
 * as requisições/respostas do serviço via JSON.
 */
@RestController
/*
 * Exponde todos os endpoints HTTP nesta classe com o prefixo
 * /v1/organization/{organizationId}/license.
 */
@RequestMapping(value = "v1/organization/{organizationId}/license")
public class LicenseController {

	@Autowired
	private LicenseService licenseService;

	LicenseController(LicenseService lincenseService) {

		this.licenseService = licenseService;
	}

	
	/*
	 * 
	 * HATEOAS significa Hipermídia como o Motor do Estado da Aplicação
	 * 
	 * 
	 * 
	 * .O princípio HATEOAS afirma que uma API deve fornecer um guia ao cliente, 
	 * retornando informações sobre os possíveis próximos passos com cada resposta do serviço.
	 *  Este projeto não é uma funcionalidade central ou obrigatória, 
	 * mas se você deseja ter um guia completo para todos os serviços da API de um determinado recurso, é uma excelente opção
	 */
	
	
	@GetMapping("/{licenseId}")
	public ResponseEntity<License> getLicense(@PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId) {

		License license = licenseService.getLicense(licenseId, organizationId);

		/*
		 * O método add() é um método do RepresentationModel.
		 * 
		 * 
		 * O método linkTo inspeciona a classe do controlador License e obtém o mapeamento raiz, 
		 * enquanto o método methodOn obtém o mapeamento do método fazendo uma invocação fictícia do método de destino.
		 * 
		 * 
		 */
		license.add(
				linkTo(methodOn(LicenseController.class).getLicense(organizationId, license.getLicenseId()))
						.withSelfRel(),
				linkTo(methodOn(LicenseController.class).createLicense(organizationId, license, null))
						.withRel("createLicense"),
				linkTo(methodOn(LicenseController.class).updateLicense(organizationId, license))
						.withRel("updateLicense"),
				linkTo(methodOn(LicenseController.class).deleteLicense(organizationId, license.getLicenseId()))
						.withRel("deleteLicense"));	
		return ResponseEntity.ok(license);

	}

	@PutMapping
	public ResponseEntity<String> updateLicense(@PathVariable("organizationId") String organizationId,
			@RequestBody License request) {
		return ResponseEntity.ok(licenseService.updateLicense(request, organizationId));
	}

	@PostMapping
	public ResponseEntity<String> createLicense(@PathVariable("organizationId") String organizationId,

			@RequestBody License request, @RequestHeader(value = "Accept-Language", required = false) Locale locale) {

		return ResponseEntity.ok(licenseService.createLicense(request, organizationId, locale));
	}

	@DeleteMapping(value = "/{licenseId}")
	public ResponseEntity<String> deleteLicense(@PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId) {
		return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId));
	}

}
