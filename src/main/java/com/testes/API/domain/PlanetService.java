package com.testes.API.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanetService {
    private final PlanetRepository repository;

    public Planet criandoPlaneta(Planet planet){
       return repository.save(planet);
    }
    public void deletarPorId(Long id){
        repository.deleteById(id);
    }
    public Optional<Planet> buscaPorId(Long id){
        return repository.findById(id);
    }
    public Optional<Planet> buscaPorNome(String nome){
        return repository.findByName(nome);
    }
}
