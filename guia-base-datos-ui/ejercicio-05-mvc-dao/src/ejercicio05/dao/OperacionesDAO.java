package ejercicio05.dao;

import ejercicio05.modelo.Empleado;
import java.util.List;

public interface OperacionesDAO {

    void insertar(Empleado empleado);

    void modificar(Empleado empleado);

    void eliminar(int id);

    List<Empleado> consultarTodos();
}
