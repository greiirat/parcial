package ejercicio06.dao;

import ejercicio06.modelo.Empleado;
import ejercicio06.util.ConexionDB;
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
            pstmt.executeUpdate();

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
            pstmt.executeUpdate();

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
                lista.add(new Empleado(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("departamento")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }

        return lista;
    }
}
