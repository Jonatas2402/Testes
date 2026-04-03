package com.testes.API.web.controller;

import com.testes.API.domain.Planet;
import com.testes.API.domain.PlanetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("planet")
@RequiredArgsConstructor
public class PlanetController {
    private final PlanetService service;

    @PostMapping
    public ResponseEntity<Planet> criandoPlanete(@RequestBody Planet planet){
        Planet create = service.criandoPlaneta(planet);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePorId(@PathVariable("id") Long id){
        service.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Planet> findById(@PathVariable("id") Long id){
        return service.buscaPorId(id).map(planet -> ResponseEntity.ok(planet))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
