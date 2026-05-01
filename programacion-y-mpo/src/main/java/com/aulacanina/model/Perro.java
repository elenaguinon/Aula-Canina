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

    public int getIdPerro() {
        return idPerro;
    }

    public void setIdPerro(int idPerro) {
        this.idPerro = idPerro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return idPerro + " - " + nombre + " (" + raza + ")";
    }
}