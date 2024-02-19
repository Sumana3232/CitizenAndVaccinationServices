package com.vaccine.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaccine.entity.Vaccination;

@Repository
public interface VaccinationRepo extends JpaRepository<Vaccination, Integer> {

}
