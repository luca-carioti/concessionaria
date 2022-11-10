package com.example.concessionaria.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date immatricolazione;
}
