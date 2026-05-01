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
                SELECT id_Reserva, Fecha_Reserva, Fecha_Servicio, Hora_Servicio,
                       Estado, Observaciones, id_Cliente, id_Perro, id_Empleado, id_Servicio
                FROM RESERVA
                ORDER BY Fecha_Servicio DESC, Hora_Servicio DESC
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reserva reserva = new Reserva(
                        rs.getInt("id_Reserva"),
                        rs.getDate("Fecha_Reserva").toLocalDate(),
                        rs.getDate("Fecha_Servicio").toLocalDate(),
                        rs.getTime("Hora_Servicio").toLocalTime(),
                        rs.getString("Estado"),
                        rs.getString("Observaciones"),
                        rs.getInt("id_Cliente"),
                        rs.getInt("id_Perro"),
                        rs.getInt("id_Empleado"),
                        rs.getInt("id_Servicio")
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
                INSERT INTO RESERVA
                (Fecha_Reserva, Fecha_Servicio, Hora_Servicio, Estado, Observaciones,
                 id_Cliente, id_Perro, id_Empleado, id_Servicio)
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
                UPDATE RESERVA
                SET Estado = 'Cancelada'
                WHERE id_Reserva = ?
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
                DELETE FROM RESERVA
                WHERE id_Reserva = ?
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