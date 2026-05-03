package com.aulacanina.dao;

import com.aulacanina.database.DBConnection;
import com.aulacanina.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        String sql = """
                SELECT id_cliente, nombre, apellidos, telefono, email
                FROM cliente
                ORDER BY nombre
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("telefono"),
                        rs.getString("email")
                );

                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }

        return clientes;
    }
}