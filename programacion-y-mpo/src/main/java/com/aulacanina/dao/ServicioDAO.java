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
                SELECT id_Servicio, Nombre, Descripcion, Duracion, Precio, Activo
                FROM SERVICIO
                WHERE Activo = true
                ORDER BY Nombre
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Servicio servicio = new Servicio(
                        rs.getInt("id_Servicio"),
                        rs.getString("Nombre"),
                        rs.getString("Descripcion"),
                        rs.getInt("Duracion"),
                        rs.getBigDecimal("Precio"),
                        rs.getBoolean("Activo")
                );

                servicios.add(servicio);
            }

        } catch (Exception e) {
            System.out.println("Error al listar servicios: " + e.getMessage());
        }

        return servicios;
    }
}