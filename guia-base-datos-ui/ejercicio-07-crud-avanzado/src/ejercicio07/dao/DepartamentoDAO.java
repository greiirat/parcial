package ejercicio07.dao;

import ejercicio07.modelo.Departamento;
import ejercicio07.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {

    public List<Departamento> consultarTodos() {
        List<Departamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM departamentos";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Departamento(
                        rs.getInt("id_depto"),
                        rs.getString("nombre_depto")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar departamentos: " + e.getMessage());
        }

        return lista;
    }
}
