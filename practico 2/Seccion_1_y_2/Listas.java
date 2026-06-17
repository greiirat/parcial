import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Listas {
    public static void main(String[] args) {
        // Ejercicio 2.1
        ArrayList<String> persona = new ArrayList<>(){{
            add("Agustin"); 
            add("Brenda");
            add("Santiago"); 
        }};

        persona.set(2, "Matias");
        persona.remove(2);

        System.out.println(persona);
        System.out.println(persona.get(0));

        //Ejercicio 2.2

        List<String> frutas = List.of("Manzana","Pera","Naranja");

        //frutas.add("Banana");
        System.out.println(frutas);

        LinkedList<String> lista = new LinkedList<>(frutas);

        lista.add(1,"Banana");
        lista.addFirst("Frutilla");
        lista.addLast("Uva");

        System.out.println("Lista final(Mutuable y Adaptada" + lista);
        

    }
}
