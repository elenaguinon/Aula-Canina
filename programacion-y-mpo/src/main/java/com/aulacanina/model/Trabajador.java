package com.aulacanina.model;

public class Trabajador {

    private int idEmpleado;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private String puesto;

    public Trabajador() {
    }

    public Trabajador(int idEmpleado, String nombre, String apellidos, String telefono, String email, String puesto) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.puesto = puesto;
    }

    public Trabajador(String nombre, String apellidos, String telefono, String email, String puesto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.puesto = puesto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getPuesto() {
        return puesto;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " - " + puesto;
    }
}