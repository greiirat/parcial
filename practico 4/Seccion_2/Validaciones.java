public class Validaciones {
    public static void main(String[] args) {
        // Ejercicio 2.1
        try {
            registrarUsuario(null, 25);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Ejercicio 2.2
        try {
            registrarUsuario("Agustin", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error especifico: " + e.getMessage());
        }
    }

    public static void registrarUsuario(String nombre, int edad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
        System.out.println("Usuario registrado: " + nombre);
    }
}
