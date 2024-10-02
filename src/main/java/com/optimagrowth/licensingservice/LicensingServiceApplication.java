package com.optimagrowth.licensingservice;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/*
 * 
 * A primeira coisa a notar neste código é o uso da anotação @SpringBootApplication. 
 * O Spring Boot utiliza essa anotação para informar ao contêiner Spring que esta classe 
 * é a fonte de definições de beans. 
 * 
 * Em uma aplicação Spring Boot, você pode definir beans do Spring por meio de:
   Anotando uma classe Java com uma tag de anotação @Component, @Service ou @Repository.
   Anotando uma classe com uma tag @Configuration e, em seguida, definindo um método de fábrica para cada bean do Spring que você deseja criar com uma tag @Bean.
 */

/*
 * 
 * 
 * Um bean do Spring é um objeto que o framework Spring gerencia em tempo de execução 
 * com o contêiner de Inversão de Controle (IoC). Esses objetos são criados e adicionados 
 * a um "repositório de objetos" para que você possa acessá-los posteriormente.
 * 
 */

@SpringBootApplication
public class LicensingServiceApplication {

	public static void main(String[] args) {

		/*
		 * . A chamada SpringApplication.run(LicenseServiceApplication.class, args) no
		 * método main() inicia o contêiner Spring e retorna um objeto
		 * ApplicationContext do Spring
		 */
		SpringApplication.run(LicensingServiceApplication.class, args);
	}

	/*
	 * 
	 * A internacionalização é um requisito essencial para permitir que sua aplicação se adapte a diferentes idiomas. 
	 * O objetivo principal aqui é desenvolver aplicações que ofereçam conteúdo em múltiplos formatos e idiomas. 
	 * 
	 */
	
	
	/*
	 * 
	 * 
	 *  atualizaremos a classe bootstrap LicenseServiceApplication.java para criar um LocaleResolver e
	 *   um ResourceBundleMessageSource para nosso serviço de licenciamento. 
	 * 
	 * 
	 */
	
	
	/*
	 * 
	 *  método localeResolver() cria um bean do tipo LocaleResolver, que é usado para resolver o Locale atual para a aplicação.
	 *  
       O SessionLocaleResolver é uma implementação que armazena o Locale na sessão do usuário. Isso significa que cada usuário 
       pode ter um Locale diferente durante a sua sessão.
       
       
       O método setDefaultLocale(Locale.US) define o Locale padrão como o dos Estados Unidos.
        Isso será usado se não houver um Locale específico definido para o usuário.
	 */
	
	@Bean
	public LocaleResolver localeResolver() {

		SessionLocaleResolver localeResolver = new SessionLocaleResolver();

		localeResolver.setDefaultLocale(Locale.US);
		
		return localeResolver;

	}
	
	/*
	 * O método messageSource() cria um bean do tipo ResourceBundleMessageSource, que é usado para carregar mensagens localizadas a partir de arquivos de propriedades.
	 * 
      A chamada setUseCodeAsDefaultMessage(true) significa que, se uma mensagem específica não for encontrada para um determinado Locale, o código da mensagem será retornado 
      como mensagem padrão. Por exemplo, se você tentar acessar uma mensagem com a chave license.create.message e essa chave não existir, o código license.create.message será retornado.
      
     A chamada setBasenames("messages") indica que o sistema deve procurar os arquivos de propriedades de mensagens com 
     o prefixo messages. Isso significa que o Spring tentará encontrar arquivos como messages.properties, messages_en.properties, ]
     messages_es.properties, etc., para fornecer as mensagens adequadas com base no Locale atual.
	 */

	@Bean
	public ResourceBundleMessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		
		messageSource.setUseCodeAsDefaultMessage(true);
		
		messageSource.setBasenames("messages");
		
		return messageSource;
	}

}
