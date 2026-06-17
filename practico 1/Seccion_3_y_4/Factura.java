// Ejercicio 3.1
public class Factura extends Documento implements Exportable, Auditable {

    // Ejercicio 3.2: Sobrescritura de método
    @Override
    public void procesar() {
        System.out.println("Procesando Factura: Validando impuestos y emitiendo comprobante fiscal.");
    }

    // Ejercicio 3.3: Sobrecarga de método en clase hija
    public void procesar(boolean esUrgente) {
        if (esUrgente) {
            System.out.println("Procesando Factura de forma PRIORITARIA.");
        } else {
            procesar(); // Llama al método original
        }
    }
    // Ejercicio 4.1
    @Override
    public void exportar() {
        System.out.println("Exportando Factura a formato PDF/XML...");
    }

    @Override
    public void registrarAuditoria() {
        System.out.println("Guardando registro de auditoría: Factura procesada por el sistema.");
    }
}
