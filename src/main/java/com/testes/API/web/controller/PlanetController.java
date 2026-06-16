package com.testes.API.web.controller;

import com.testes.API.domain.Planet;
import com.testes.API.domain.PlanetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.deser.bean.CreatorCandidate;

import java.util.List;

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
    public ResponseEntity<Planet> buscaId(@PathVariable("id") Long id){
        return service.buscaPorId(id).map(planet -> ResponseEntity.ok(planet))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/{name}")
    public ResponseEntity<Planet> buscaNome(@PathVariable("name") String nome){
        return service.buscaPorNome(nome).map(planet -> ResponseEntity.ok(planet))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    /*Busca com filtro*/
    @GetMapping
    /*@RequestParam(required = false diz que esse filtro não é obrigatório*/
    public ResponseEntity<List<Planet>> list(@RequestParam(required = false) String terrain,
                                             @RequestParam(required = false) String climate){
        List<Planet> planets = service.listaPlanetas(terrain, climate);
        return ResponseEntity.ok(planets);
    }

}