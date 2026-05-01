package com.aulacanina.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {

    private int idReserva;
    private LocalDate fechaReserva;
    private LocalDate fechaServicio;
    private LocalTime horaServicio;
    private String estado;
    private String observaciones;
    private int idCliente;
    private int idPerro;
    private int idEmpleado;
    private int idServicio;

    public Reserva() {
    }

    public Reserva(int idReserva, LocalDate fechaReserva, LocalDate fechaServicio, LocalTime horaServicio,
                   String estado, String observaciones, int idCliente, int idPerro, int idEmpleado, int idServicio) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.fechaServicio = fechaServicio;
        this.horaServicio = horaServicio;
        this.estado = estado;
        this.observaciones = observaciones;
        this.idCliente = idCliente;
        this.idPerro = idPerro;
        this.idEmpleado = idEmpleado;
        this.idServicio = idServicio;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalDate getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(LocalDate fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public LocalTime getHoraServicio() {
        return horaServicio;
    }

    public void setHoraServicio(LocalTime horaServicio) {
        this.horaServicio = horaServicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPerro() {
        return idPerro;
    }

    public void setIdPerro(int idPerro) {
        this.idPerro = idPerro;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
}