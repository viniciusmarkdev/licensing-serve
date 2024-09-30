package com.optimagrowth.licensingservice.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
/*
 * Um Objeto Java Comum (POJO) que contém as informações da licença.
 */
public class License {
	
	 private int id;
	 private String licenseId;
	 private String description;
	 private String organizationId;
	 private String productName;
	 private String licenseType;

}
