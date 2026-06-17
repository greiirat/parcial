package ejercicio05.dao;

import ejercicio05.modelo.Empleado;
import ejercicio05.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements OperacionesDAO {

    @Override
    public void insertar(Empleado empleado) {
        String sql = "INSERT INTO empleados (nombre, departamento) VALUES (?, ?)";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getDepartamento());
            pstmt.executeUpdate();
            System.out.println("Empleado '" + empleado.getNombre() + "' insertado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Empleado empleado) {
        String sql = "UPDATE empleados SET nombre = ?, departamento = ? WHERE id = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getDepartamento());
            pstmt.setInt(3, empleado.getId());

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Empleado con ID " + empleado.getId() + " actualizado.");
            } else {
                System.out.println("No se encontró empleado con ID " + empleado.getId() + ".");
            }

        } catch (SQLException e) {
            System.out.println("Error al modificar: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM empleados WHERE id = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int filas = pstmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Empleado con ID " + id + " eliminado.");
            } else {
                System.out.println("No se encontró empleado con ID " + id + ".");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    @Override
    public List<Empleado> consultarTodos() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("departamento")
                );
                lista.add(empleado);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }

        return lista;
    }
}
