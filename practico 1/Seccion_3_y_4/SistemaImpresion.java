public class SistemaImpresion {
    
    // Ejercicio 4.2: Polimorfismo a través de Interfaces
    // Este método acepta CUALQUIER objeto que cumpla con el contrato 'Exportable'
    public void enviarAImpresion(Exportable documento) {
        System.out.println("Preparando documento para impresión...");
        documento.exportar();
        System.out.println("Documento enviado a la cola de impresión.\n");
    }

    public static void main(String[] args) {
        SistemaImpresion sistema = new SistemaImpresion();
        Factura factura1 = new Factura();

        // Prueba de polimorfismo de interfaz
        sistema.enviarAImpresion(factura1);

        // También probamos el otro método de la interfaz Auditable
        factura1.registrarAuditoria();
    }
}
