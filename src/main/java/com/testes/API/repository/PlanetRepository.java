package com.testes.API.repository;

import com.testes.API.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet,Long> {

}
