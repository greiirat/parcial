import java.util.function.*;
import java.util.*;

public class Lambdas {
    public static void main(String[] args) {
        // Ejercicio 1.1
        Predicate<Integer> esPar = (n) -> n % 2 == 0;
        System.out.println("Es par 4?: " + esPar.test(4));

        Function<String, Integer> longitud = (s) -> s.length();
        System.out.println("Longitud de Hola: " + longitud.apply("Hola"));

        Consumer<Integer> imprimir = (n) -> System.out.println("Numero: " + n);
        imprimir.accept(10);

        Supplier<Double> aleatorio = () -> Math.random();
        System.out.println("Aleatorio: " + aleatorio.get());

        // Ejercicio 1.2
        List<String> textos = Arrays.asList("Java", "C", "Python", "JavaScript");
        textos.sort((a, b) -> a.length() - b.length());
        System.out.println("Ordenados por longitud: " + textos);

        // Ejercicio 1.3
        ToIntFunction<String> longitudPrimitiva = (s) -> s.length();
        System.out.println("Longitud primitiva: " + longitudPrimitiva.applyAsInt("Programacion"));

        IntPredicate esParPrimitivo = (n) -> n % 2 == 0;
        System.out.println("Es par primitivo 8?: " + esParPrimitivo.test(8));
    }
}
