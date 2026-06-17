import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestionRecursos {
    public static void main(String[] args) {
        // Ejercicio 4.1
        try (BufferedReader br = new BufferedReader(new FileReader("personas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("Leido: " + linea);
            }
        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
