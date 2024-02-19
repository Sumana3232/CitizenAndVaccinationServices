package com.vaccine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vaccine.entity.Citizen;
import com.vaccine.entity.RequiredResponse;
import com.vaccine.entity.Vaccination;
import com.vaccine.repo.VaccinationRepo;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {
    
	
		 @Autowired 
		 private RestTemplate restTemplate; 
		 @Autowired 
		 private VaccinationRepo repo; 
		 
		 @GetMapping("/test") 
		 public String testMethod() 
		 { 
		  return "Welcome To Vaccination-Center-Service"; 
		 } 
		 @PostMapping("/add") 
		 public Vaccination addVaccinationCenterDetails(@RequestBody Vaccination newVaccination) 
		 { 
		  Vaccination add=repo.save(newVaccination); 
		  return add; 
		 } 
		 @GetMapping("/get/{id}") 
		 public Vaccination getVaccinationRecord(@PathVariable int id) 
		 { 
		  Vaccination getOneRecord=repo.findById(id).get(); 
		  return getOneRecord; 
		 } 
		   
		 @GetMapping("/getData/{id}")
		 public ResponseEntity<RequiredResponse> getdata(@PathVariable int id) 
		 { 
		  RequiredResponse requiredResponse=new RequiredResponse(); 
		   
		  // This is for Vaccination Center Details 
		  Vaccination center=repo.findById(id).get(); 
		  requiredResponse.setCenter(center); 
		   
		 // Then Get citizen registered to Vaccination Details 
		 List<Citizen> listOfCitizens=restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id,List.class); 
		 requiredResponse.setCitizens(listOfCitizens);  
		 return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK); 
		 }
}

