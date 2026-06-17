package ejercicio05;

import ejercicio05.dao.EmpleadoDAO;
import ejercicio05.modelo.Empleado;

public class Main {

    public static void main(String[] args) {
        EmpleadoDAO dao = new EmpleadoDAO();

        System.out.println("=== INSERT ===");
        dao.insertar(new Empleado("Ana García", "Recursos Humanos"));

        System.out.println("\n=== UPDATE (ID 1) ===");
        dao.modificar(new Empleado(1, "Ana García", "Finanzas"));

        System.out.println("\n=== LISTADO ===");
        for (Empleado empleado : dao.consultarTodos()) {
            System.out.println(empleado);
        }

        System.out.println("\n=== DELETE (ID 1) ===");
        dao.eliminar(1);

        System.out.println("\n=== LISTADO FINAL ===");
        for (Empleado empleado : dao.consultarTodos()) {
            System.out.println(empleado);
        }
    }
}
