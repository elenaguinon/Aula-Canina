package com.aulacanina.dao;

import com.aulacanina.database.DBConnection;
import com.aulacanina.model.Perro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PerroDAO {

    public List<Perro> listarPerros() {
        List<Perro> perros = new ArrayList<>();

        String sql = """
                SELECT id_perro, nombre, raza, id_cliente
                FROM perro
                ORDER BY nombre
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                perros.add(new Perro(
                        rs.getInt("id_Perro"),
                        rs.getString("Nombre"),
                        rs.getString("Raza"),
                        rs.getInt("id_Cliente")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error al listar perros: " + e.getMessage());
        }

        return perros;
    }

    public List<Perro> listarPerrosPorCliente(int idCliente) {
        List<Perro> perros = new ArrayList<>();

        String sql = """
                SELECT id_Perro, Nombre, Raza, id_Cliente
                FROM PERRO
                WHERE id_Cliente = ?
                ORDER BY Nombre
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    perros.add(new Perro(
                            rs.getInt("id_Perro"),
                            rs.getString("Nombre"),
                            rs.getString("Raza"),
                            rs.getInt("id_Cliente")
                    ));
                }
            }

        } catch (Exception e) {
            System.out.println("Error al listar perros por cliente: " + e.getMessage());
        }

        return perros;
    }

    public List<Perro> buscarPerrosPorNombre(String nombre) {
        List<Perro> perros = new ArrayList<>();

        String sql = """
                SELECT id_perro, nombre, raza, id_cliente
                FROM PERRO
                WHERE nombre LIKE ?
                ORDER BY nombre
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nombre + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    perros.add(new Perro(
                            rs.getInt("id_perro"),
                            rs.getString("nombre"),
                            rs.getString("raza"),
                            rs.getInt("id_cliente")
                    ));
                }
            }

        } catch (Exception e) {
            System.out.println("Error al buscar perros: " + e.getMessage());
        }

        return perros;
    }

    public boolean insertarPerro(Perro perro) {
        String sql = """
                INSERT INTO perro (nombre, raza, id_cliente)
                VALUES (?, ?, ?)
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, perro.getNombre());
            ps.setString(2, perro.getRaza());
            ps.setInt(3, perro.getIdCliente());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al insertar perro: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPerro(int idPerro) {
        String sql = """
                DELETE FROM perro
                WHERE id_perro = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idPerro);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al eliminar perro: " + e.getMessage());
            return false;
        }
    }
}