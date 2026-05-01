package com.aulacanina.dao;

import com.aulacanina.database.DBConnection;
import com.aulacanina.model.Perro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PerroDAO {

    public List<Perro> listarPerrosPorCliente(int idCliente) {
        List<Perro> perros = new ArrayList<>();

        String sql = """
                SELECT id_perro, nombre, raza, id_cliente
                FROM perro
                WHERE id_cliente = ?
                ORDER BY nombre
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Perro perro = new Perro(
                            rs.getInt("id_Perro"),
                            rs.getString("Nombre"),
                            rs.getString("Raza"),
                            rs.getInt("id_Cliente")
                    );

                    perros.add(perro);
                }
            }

        } catch (Exception e) {
            System.out.println("Error al listar perros: " + e.getMessage());
        }

        return perros;
    }
}