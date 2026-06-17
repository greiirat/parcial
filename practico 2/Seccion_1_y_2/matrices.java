
import java.util.Arrays;

public class matrices {
    public static void main(String[] args) {
        //Ejercicio 1.1
        int[][] numero = new int[3][2];
        numero[0][0] = 10;
        numero[1][0] = 40;
        numero[2][0] = 50;
        int ultimo = numero[numero.length-1][0];

        System.out.println("Ultimo espacio en la matriz: "+ultimo);

        // ejercicio 1.2
        String[] nombre = {"Santiago","Matias","Agustin", "Brenda"};
        Arrays.sort(nombre); 

        String key= "Santiago";

        int Posicion = Arrays.binarySearch(nombre, key );

        System.out.println("Posicion: "+ Posicion);

    }
}
