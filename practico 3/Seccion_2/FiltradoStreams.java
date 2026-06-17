import java.util.stream.Stream;

public class FiltradoStreams {
    public static void main(String[] args) {
        // Ejercicio 2.1
        long total = Stream.of(2, 5, 3, 3, 6, 2, 4)
                .distinct()
                .skip(1)
                .limit(3)
                .count();
        System.out.println("Total elementos: " + total);

        // Ejercicio 2.2
        Stream.of(1, 2, 3, 4, 5, 6)
                .filter(n -> n > 3)
                .peek(n -> System.out.println("Pasando por peek: " + n))
                .count();
    }
}
