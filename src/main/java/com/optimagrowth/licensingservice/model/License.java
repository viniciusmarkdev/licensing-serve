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
	 
	 
	 
	 
	public License() {
		super();
	}
	public License(int id, String licenseId, String description, String organizationId, String productName,
			String licenseType) {
		super();
		this.id = id;
		this.licenseId = licenseId;
		this.description = description;
		this.organizationId = organizationId;
		this.productName = productName;
		this.licenseType = licenseType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	 
	 
	 
	 

}
