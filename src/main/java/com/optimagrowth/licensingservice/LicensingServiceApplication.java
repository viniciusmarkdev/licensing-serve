package com.optimagrowth.licensingservice;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		 * . A chamada SpringApplication.run(LicenseServiceApplication.class, args) no método main() 
		 * inicia o contêiner Spring e retorna um objeto ApplicationContext do Spring
		 */
		SpringApplication.run(LicensingServiceApplication.class, args);
	}

}
