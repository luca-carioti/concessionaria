package com.example.concessionaria.models;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Marca {
    public Marca() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "nazionalit√†", length = 200)
    private String nazionalita;
    private int numeroModelli;


}
