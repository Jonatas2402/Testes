package com.testes.API.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.Objects;

@Entity
@Table(name = "planet")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String terrain;
    private String climate;


    public Planet(String name, String terrain, String climate) {
        this.name = name;
        this.terrain = terrain;
        this.climate = climate;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(obj, this);
    }
}
