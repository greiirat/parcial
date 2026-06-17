import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Clase Empleado para el Ejercicio 5.1
class Empleado implements Comparable<Empleado> {
    private String nombre;
    private int edad;

    public Empleado(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    // Sobrescritura de compareTo para orden natural por EDAD
    @Override
    public int compareTo(Empleado otro) {
        return Integer.compare(this.edad, otro.edad);
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}

// Clase Comparador para el Ejercicio 5.2
class ComparadorNombre implements Comparator<Empleado> {
    @Override
    public int compare(Empleado e1, Empleado e2) {
        return e1.getNombre().compareTo(e2.getNombre());
    }
}

public class OrdenamientoAvanzado {
    public static void main(String[] args) {
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("Santiago", 30));
        listaEmpleados.add(new Empleado("Agustín", 25));
        listaEmpleados.add(new Empleado("Brenda", 28));

        // Ejercicio 5.1: Orden Natural (por Edad)
        System.out.println("--- Ejercicio 5.1: Orden Natural (por Edad) ---");
        Collections.sort(listaEmpleados);
        for (Empleado e : listaEmpleados) {
            System.out.println(e);
        }

        // Ejercicio 5.2: Orden Personalizado (por Nombre)
        System.out.println("\n--- Ejercicio 5.2: Orden Personalizado (por Nombre) ---");
        Collections.sort(listaEmpleados, new ComparadorNombre());
        for (Empleado e : listaEmpleados) {
            System.out.println(e);
        }
    }
}
