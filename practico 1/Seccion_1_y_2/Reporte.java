public class Reporte {

    public static void main(String[] args) {
        Reporte reporte = new Reporte();
        
        // Ejercicio 2.1
        reporte.generarEncabezado();
        System.out.println(reporte.obtenerCuepo());

        System.out.println("\n--- Prueba Ejercicio 2.3 (Var-args) ---");
        
        // Llamada con tres cadenas distintas
        reporte.agregarSecciones("Introducción", "Desarrollo", "Conclusión");

        System.out.println("\n--- Prueba sin argumentos ---");
        
        // Llamada sin pasarle nada
        reporte.agregarSecciones(); 
    }
    
    // Ejercicio 2.1: Método sin retorno
    public void generarEncabezado() {
        System.out.println("=== Reporte ===");
    }

    // Ejercicio 2.1: Método con retorno
    public String obtenerCuepo(){
        return "Este es el cuerpo del reporte.";
    }

    // Ejercicio 2.3: Método con argumentos variables (var-args)
    public void agregarSecciones(String... secciones) {
        // El bucle for-each recorre automáticamente la "bolsa" de secciones
        for (String seccion : secciones) {
            System.out.println("- " + seccion);
        }
        
        // Verificación lógica: si el arreglo está vacío
        if (secciones.length == 0) {
            System.out.println("No se detectaron secciones adicionales.");
        }
    }
}