/**
 * @version 1.0
 */

// Ejercicio 1.1
public class SistemaGestor {

    /* BLOQUE DE CONFIGURACIÓN:
    Aquí se definen las constantes globales del sistema.
    Se utiliza 'static' para que la variable pertenezca a la clase y no a la instancia,
    ahorrando memoria al no replicarse en cada objeto.
    */
    // Ejercicio 1.2
    public static final int MAX_CONEXIONES = 10;
    

    public static void main(String[] args) {
        // Creación de una instancia de SistemaGestor
        SistemaGestor gestor = new SistemaGestor();
        gestor.mostrarConfiguracion();
    }

    public void mostrarConfiguracion() {
        // Variable local para el contexto del método
        int tiempoEspera = 5000; 
        
        System.out.println("Máximo de conexiones permitidas: " + MAX_CONEXIONES);
    }

}
