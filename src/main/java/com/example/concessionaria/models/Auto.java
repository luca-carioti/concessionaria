package com.example.concessionaria.models;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Accessors(fluent = true)
public class Auto {
    public Auto() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modello;
    @ManyToOne
    @JoinColumn(name = "marca", referencedColumnName = "id")
    private Marca marca;
    private double cilindrata;
    private String targa;
    private String colore;
    private double chilometraggio;
    private String tipoCarburante;
    @Temporal(TemporalType.DATE)
    private Date immatricolazione;
}
