package ejercicio07.dao;

import ejercicio07.modelo.Empleado;
import ejercicio07.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements OperacionesDAO {

    @Override
    public void insertar(Empleado empleado) {
        String sql = "INSERT INTO empleados (nombre, id_departamento, foto) VALUES (?, ?, ?)";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empleado.getNombre());
            pstmt.setInt(2, empleado.getIdDepartamento());
            pstmt.setString(3, empleado.getFoto());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Empleado empleado) {
        String sql = "UPDATE empleados SET nombre = ?, id_departamento = ?, foto = ? WHERE id = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empleado.getNombre());
            pstmt.setInt(2, empleado.getIdDepartamento());
            pstmt.setString(3, empleado.getFoto());
            pstmt.setInt(4, empleado.getId());
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
        String sql = """
                SELECT e.id, e.nombre, e.id_departamento, d.nombre_depto, e.foto
                FROM empleados e
                INNER JOIN departamentos d ON e.id_departamento = d.id_depto
                """;

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Empleado(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("id_departamento"),
                        rs.getString("nombre_depto"),
                        rs.getString("foto")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }

        return lista;
    }
}
