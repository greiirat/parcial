import java.util.HashMap;
import java.util.TreeMap;

public class Mapas {
    public static void main(String[] args) {
        
        // Ejercicio 4.1: Manejo de HashMap
        System.out.println("--- Ejercicio 4.1: HashMap ---");
        HashMap<Integer, String> usuarios = new HashMap<>();

        // Agregar entradas (put)
        usuarios.put(101, "Agustín");
        usuarios.put(105, "Brenda");
        usuarios.put(103, "Santiago");

        // Recuperar un nombre (get)
        System.out.println("Usuario con ID 103: " + usuarios.get(103));

        // Actualizar un nombre (replace)
        usuarios.replace(105, "Brenda Sofía");
        System.out.println("Usuario 105 actualizado: " + usuarios.get(105));

        // Eliminar un registro (remove)
        usuarios.remove(101);
        System.out.println("Mapa después de eliminar ID 101: " + usuarios);


        // Ejercicio 4.2: Ordenamiento con TreeMap
        System.out.println("\n--- Ejercicio 4.2: TreeMap (Orden Natural) ---");
        TreeMap<Integer, String> usuariosOrdenados = new TreeMap<>();

        // Agregamos los mismos datos
        usuariosOrdenados.put(101, "Agustín");
        usuariosOrdenados.put(105, "Brenda");
        usuariosOrdenados.put(103, "Santiago");

        // Al recorrer las claves, veremos que están ordenadas automáticamente
        System.out.println("Recorriendo TreeMap (las claves 101, 103, 105 saldrán ordenadas):");
        for (Integer id : usuariosOrdenados.keySet()) {
            System.out.println("ID: " + id + " - Nombre: " + usuariosOrdenados.get(id));
        }
    }
}
