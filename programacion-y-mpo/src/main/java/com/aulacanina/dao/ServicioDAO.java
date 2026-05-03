package com.aulacanina.dao;

import com.aulacanina.database.DBConnection;
import com.aulacanina.model.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO {

    public List<Servicio> listarServiciosActivos() {
        List<Servicio> servicios = new ArrayList<>();

        String sql = """
                SELECT id_Servicio, nombre, descripcion, duracion, precio, activo
                FROM servicio
                WHERE Activo = true
                ORDER BY Nombre
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Servicio servicio = new Servicio(
                        rs.getInt("id_servicio"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("duracion"),
                        rs.getBigDecimal("precio"),
                        rs.getBoolean("activo")
                );

                servicios.add(servicio);
            }

        } catch (Exception e) {
            System.out.println("Error al listar servicios: " + e.getMessage());
        }

        return servicios;
    }
}