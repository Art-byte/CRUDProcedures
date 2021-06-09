package com.ejemplo.CRUDProcedures.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marca;
    private String modelo;
    private int anio;
    private int km;

    public Coche(){}

    public Coche(int id, String marca, String modelo, int anio, int km){
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.km = km;
    }
}
