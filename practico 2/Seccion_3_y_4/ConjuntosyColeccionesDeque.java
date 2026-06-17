import java.util.HashSet;
import java.util.ArrayDeque;

public class ConjuntosyColeccionesDeque {
    public static void main(String[] args) {
        
        // Ejercicio 3.1: Unicidad en Sets (HashSet)
        System.out.println("--- Ejercicio 3.1: HashSet ---");
        HashSet<Integer> numeros = new HashSet<>();

        // Intentamos insertar el mismo número tres veces
        numeros.add(10);
        numeros.add(10);
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        System.out.println("Tamaño del conjunto (debería ser 3): " + numeros.size());
        
        if (numeros.contains(20)) {
            System.out.println("El número 20 existe en el conjunto.");
            numeros.remove(20);
            System.out.println("Número 20 eliminado.");
        }

        System.out.println("Contenido del HashSet (sin orden garantizado): " + numeros);


        // Ejercicio 3.2: Colas de doble extremo (ArrayDeque)
        System.out.println("\n--- Ejercicio 3.2: ArrayDeque ---");
        ArrayDeque<String> colaDoble = new ArrayDeque<>();

        // Agregamos elementos por ambos extremos
        colaDoble.addFirst("Cliente A (Urgente)");
        colaDoble.addLast("Cliente B (Normal)");
        colaDoble.addFirst("Cliente C (Muy Urgente)");

        System.out.println("Estado de la cola: " + colaDoble);

        // Recuperamos y eliminamos de los extremos
        System.out.println("Atendiendo primero: " + colaDoble.removeFirst());
        System.out.println("Atendiendo último: " + colaDoble.removeLast());

        System.out.println("Estado final de la cola: " + colaDoble);
    }
}
