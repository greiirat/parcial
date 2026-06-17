public class ManejoBasico {
    public static void main(String[] args) {
        // Ejercicio 1.1
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("Clase: " + e.getClass().getName());
        }

        // Ejercicio 1.2
        try {
            int resultado = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error aritmetico detectado.");
        } finally {
            System.out.println("Limpieza final");
        }

        // Ejercicio 1.3
        try {
            String dato = "100a";
            int n = Integer.parseInt(dato);
            int division = 100 / n;
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("Error de calculo o conversion");
        }
    }
}
