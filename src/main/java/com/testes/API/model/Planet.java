package com.testes.API.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "planet")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    private Long id;
    private String name;
    private String terrain;
    private String  climate;
}
