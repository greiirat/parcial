package ejercicio07.dao;

import ejercicio07.modelo.Empleado;
import java.util.List;

public interface OperacionesDAO {

    void insertar(Empleado empleado);

    void modificar(Empleado empleado);

    void eliminar(int id);

    List<Empleado> consultarTodos();
}
