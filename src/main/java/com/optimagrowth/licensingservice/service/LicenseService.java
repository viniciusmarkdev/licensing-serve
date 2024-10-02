package com.optimagrowth.licensingservice.service;

import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.optimagrowth.licensingservice.model.License;

@Service
public class LicenseService {
	
	/*
	 * 
	 * MessageSource: Esta é uma interface no Spring que fornece suporte para resolução de mensagens, 
	 * incluindo internacionalização (i18n). Ele é usado para recuperar mensagens de propriedades em diferentes 
	 * idiomas com base na localização (Locale).

      messages: Esta é a variável que armazenará a instância de MessageSource injetada pelo Spring. 
      Assim, você pode usar messages para acessar as mensagens definidas em arquivos de propriedades 
     (como messages.properties, messages_en.properties, etc.) em seu código.
	 */
	
	@Autowired
	MessageSource messages;

	
	public License getLicense(String licenseId, String organizationId) {

		License license = new License();

		license.setId(new Random().nextInt(1000));
		license.setLicenseId(licenseId);
		license.setOrganizationId(organizationId);
		license.setDescription("Software product");
		license.setProductName("Ostock");
		license.setLicenseType("full");
		return license;
	}
	
	/*
	 * 
	 * Recebe o Locale como um parâmetro do método.
	 */

	public String createLicense(License license, String organizationId , Locale locale) {

		String responseMessage = null;

		if (license != null) {
			
			
			/*
			 * Quando uma mensagem não é encontrada, essa opção retorna o código da mensagem 'license.creates.message' em vez de um erro como este:
               "Nenhuma mensagem encontrada sob o código 'license.creates.message' para o local 'es'."
			 */
			responseMessage = String.format(messages.getMessage(
					
					 "license.create.message", null,locale),
					
					 license.toString());

	

		}

		return responseMessage;
	}

	public String updateLicense(License license, String organizationId) {

		String responseMessage = null;
		if (license != null) {

			license.setOrganizationId(organizationId);
			
			responseMessage = String.format(messages.getMessage(
					 "license.update.message", null, null),
					 license.toString());

		}
		return responseMessage;

	}

	public String deleteLicense(String licenseId, String organizationId){
		 String responseMessage = null;
		 responseMessage = String.format("Deleting license with id %s for the organization %s",licenseId, organizationId);
		 return responseMessage;
		 }

}
