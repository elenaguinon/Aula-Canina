package com.aulacanina.dao;

import com.aulacanina.database.DBConnection;
import com.aulacanina.model.Trabajador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAO {

    public List<Trabajador> listarTrabajadores() {
        List<Trabajador> trabajadores = new ArrayList<>();

        String sql = """
                SELECT id_empleado, nombre, apellidos, telefono, Email
                FROM empleado
                ORDER BY nombre
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                trabajadores.add(new Trabajador(
                ));
            }

        } catch (Exception e) {
            System.out.println("Error al listar trabajadores: " + e.getMessage());
        }

        return trabajadores;
    }

    public boolean insertarTrabajador(Trabajador trabajador) {
        String sql = """
                INSERT INTO empleado (nombre, apellidos, telefono, email)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, trabajador.getNombre());
            ps.setString(2, trabajador.getApellidos());
            ps.setString(3, trabajador.getTelefono());
            ps.setString(4, trabajador.getEmail());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al insertar trabajador: " + e.getMessage());
            return false;
        }
    }
}