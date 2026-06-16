package com.testes.API.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Planet> listaPlanetas(String climate, String terrain){
        Example<Planet> query = QueryBuilder.makeQuery(new Planet(terrain, climate));
        return repository.findAll(query);
    }
}
