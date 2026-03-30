package com.testes.API.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
