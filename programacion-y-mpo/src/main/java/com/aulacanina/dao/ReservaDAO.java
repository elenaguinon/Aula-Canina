package com.aulacanina.dao;

import com.aulacanina.database.DBConnection;
import com.aulacanina.model.Reserva;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public List<Reserva> listarReservas() {
        List<Reserva> reservas = new ArrayList<>();

        String sql = """
                SELECT id_reserva, fecha_reserva, fecha_servicio, hora_servicio,
                       estado, observaciones, id_cliente, id_perro, id_empleado, id_servicio
                FROM reserva
                ORDER BY fecha_servicio DESC, hora_servicio DESC
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reserva reserva = new Reserva(
                        rs.getInt("id_reserva"),
                        rs.getDate("fecha_reserva").toLocalDate(),
                        rs.getDate("fecha_servicio").toLocalDate(),
                        rs.getTime("hora_servicio").toLocalTime(),
                        rs.getString("estado"),
                        rs.getString("observaciones"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_perro"),
                        rs.getInt("id_empleado"),
                        rs.getInt("id_servicio")
                );

                reservas.add(reserva);
            }

        } catch (Exception e) {
            System.out.println("Error al listar reservas: " + e.getMessage());
        }

        return reservas;
    }

    public boolean insertarReserva(Reserva reserva) {
        String sql = """
                INSERT INTO reserva
                (fecha_reserva, fecha_servicio, hora_servicio, estado, observaciones,
                 id_cliente, id_perro, id_empleado, id_servicio)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(reserva.getFechaReserva()));
            ps.setDate(2, Date.valueOf(reserva.getFechaServicio()));
            ps.setTime(3, Time.valueOf(reserva.getHoraServicio()));
            ps.setString(4, reserva.getEstado());
            ps.setString(5, reserva.getObservaciones());
            ps.setInt(6, reserva.getIdCliente());
            ps.setInt(7, reserva.getIdPerro());
            ps.setInt(8, reserva.getIdEmpleado());
            ps.setInt(9, reserva.getIdServicio());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            System.out.println("Error al insertar reserva: " + e.getMessage());
            return false;
        }
    }

    public boolean cancelarReserva(int idReserva) {
        String sql = """
                UPDATE reserva
                SET Estado = 'Cancelada'
                WHERE id_reserva = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idReserva);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            System.out.println("Error al cancelar reserva: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarReserva(int idReserva) {
        String sql = """
                DELETE FROM reserva
                WHERE id_reserva = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idReserva);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            System.out.println("Error al eliminar reserva: " + e.getMessage());
            return false;
        }
    }
}