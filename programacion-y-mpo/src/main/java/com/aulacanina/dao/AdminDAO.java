package com.aulacanina.dao;

import com.aulacanina.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

    public boolean validarLogin(String usuario, String password) {
        String sql = """
                SELECT id_Admin
                FROM ADMINISTRADOR
                WHERE Usuario = ? AND Password = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (Exception e) {
            System.out.println("Error al validar login: " + e.getMessage());
            return false;
        }
    }
}