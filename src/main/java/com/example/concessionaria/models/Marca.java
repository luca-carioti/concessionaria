package com.example.concessionaria.models;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Accessors(fluent = true)
public class Marca {
    public Marca() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "nazionalità", length = 200)
    private String nazionalita;
    private int numeroModelli;


}
