import java.util.*;
import java.util.stream.*;

class Persona {
    private String dni;
    private String nombre;

    public Persona(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
}

public class TransformacionYFinales {
    public static void main(String[] args) {
        // Ejercicio 3.1
        Stream.of("Juan", "Maria", "Ana")
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        // Ejercicio 3.2
        int sumaLetras = Stream.of("Juan", "Maria", "Ana")
                .mapToInt(s -> s.length())
                .sum();
        System.out.println("Suma total de letras: " + sumaLetras);

        // Ejercicio 3.3
        List<List<String>> sublistas = Arrays.asList(
                Arrays.asList("Pedro", "Juan"),
                Arrays.asList("Ana", "Maria", "Sebastian")
        );
        long masDeCuatro = sublistas.stream()
                .flatMap(l -> l.stream())
                .filter(s -> s.length() > 4)
                .count();
        System.out.println("Nombres con mas de 4 letras: " + masDeCuatro);

        // Ejercicio 3.4
        Stream.of("Java", "C", "Python")
                .sorted()
                .sorted((a, b) -> a.length() - b.length())
                .forEach(n -> System.out.println("Ordenado: " + n));

        // Ejercicio 4.1
        boolean algunoMayorCinco = Stream.of(2, 5, 7, 3, 6, 2, 3).anyMatch(n -> n > 5);
        System.out.println("Alguno mayor a 5?: " + algunoMayorCinco);

        // Ejercicio 4.2
        Optional<Integer> primeroPar = Stream.of(1, 3, 4, 5, 6)
                .filter(n -> n % 2 == 0)
                .findFirst();
        if (primeroPar.isPresent()) {
            System.out.println("Primer par encontrado: " + primeroPar.get());
        }

        // Ejercicio 4.3
        int suma = Stream.of(10, 20, 30).reduce((a, b) -> a + b).get();
        System.out.println("Suma reduce: " + suma);

        // Ejercicio 4.4
        List<Integer> listaLimpia = Stream.of(1, 2, 2, 3, 3, 4)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Lista sin duplicados: " + listaLimpia);

        List<Persona> personas = Arrays.asList(
                new Persona("123", "Agustin"),
                new Persona("456", "Brenda")
        );
        Map<String, String> mapaPersonas = personas.stream()
                .collect(Collectors.toMap(p -> p.getDni(), p -> p.getNombre()));
        System.out.println("Mapa de personas: " + mapaPersonas);
    }
}
