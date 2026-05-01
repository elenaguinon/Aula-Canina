package com.aulacanina.model;

public class Perro {

    private int idPerro;
    private String nombre;
    private String raza;
    private int idCliente;

    public Perro() {
    }

    public Perro(int idPerro, String nombre, String raza, int idCliente) {
        this.idPerro = idPerro;
        this.nombre = nombre;
        this.raza = raza;
        this.idCliente = idCliente;
    }

    public Perro(String nombre, String raza, int idCliente) {
        this.nombre = nombre;
        this.raza = raza;
        this.idCliente = idCliente;
    }

    public int getIdPerro() {
        return idPerro;
    }

    public void setIdPerro(int idPerro) {
        this.idPerro = idPerro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public int getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return nombre + " - " + raza;
    }
}