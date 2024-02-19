package com.vaccine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vaccination {
	@Id
    private int id;
    private String centerName;
    private String centerAddress;
	public Vaccination() {
		super();
	}
	public Vaccination(int id, String centerName, String centerAddress) {
		super();
		this.id = id;
		this.centerName = centerName;
		this.centerAddress = centerAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterAddress() {
		return centerAddress;
	}
	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}
	@Override
	public String toString() {
		return "Vaccination [id=" + id + ", centerName=" + centerName + ", centerAddress=" + centerAddress + "]";
	}
    
}
