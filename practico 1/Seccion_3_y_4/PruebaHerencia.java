public class PruebaHerencia {
    public static void main(String[] args) {
        // Ejercicio 3.2: Demostración de Polimorfismo
        // Usamos el tipo de referencia de la superclase (Documento)
        Documento doc1 = new Factura();
        Documento doc2 = new Recibo();

        System.out.println("--- Prueba de Polimorfismo ---");
        doc1.procesar(); // Ejecuta la versión de Factura
        doc2.procesar(); // Ejecuta la versión de Recibo

        System.out.println("\n--- Prueba de Sobrecarga en Factura ---");
        Factura miFactura = new Factura();
        miFactura.procesar(true);  // Versión urgente
        miFactura.procesar(false); // Versión estándar
    }
}
