package com.vaccine.entity;

import java.util.List;

public class RequiredResponse {
   private Vaccination center;
   private List<Citizen> citizens;
public RequiredResponse() {
	super();
}
public RequiredResponse(Vaccination center, List<Citizen> citizens) {
	super();
	this.center = center;
	this.citizens = citizens;
}
public Vaccination getCenter() {
	return center;
}
public void setCenter(Vaccination center) {
	this.center = center;
}
public List<Citizen> getCitizens() {
	return citizens;
}
public void setCitizens(List<Citizen> citizens) {
	this.citizens = citizens;
}
@Override
public String toString() {
	return "RequiredResponse [center=" + center + ", citizens=" + citizens + "]";
}
   
}
