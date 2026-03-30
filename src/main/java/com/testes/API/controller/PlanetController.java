package com.testes.API.controller;

import com.testes.API.model.Planet;
import com.testes.API.service.PlanetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("planet")
@RequiredArgsConstructor
public class PlanetController {
    private final PlanetService service;

    @PostMapping
    public ResponseEntity<Planet> criandoPlanete(Planet planet){
        Planet create = service.criandoPlaneta(planet);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePorId(Long id){
        service.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
