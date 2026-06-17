public class CicloVidaHilos {
    public static void main(String[] args) throws InterruptedException {
        // Ejercicio 4.1
        Thread hiloPrioridad = new Thread(() -> {
            System.out.println("Hilo: " + Thread.currentThread().getName() + " - Prioridad: " + Thread.currentThread().getPriority());
        });

        hiloPrioridad.setName("HiloPrioridad");
        hiloPrioridad.setPriority(Thread.MAX_PRIORITY);
        hiloPrioridad.start();

        // Ejercicio 4.2
        Thread hiloLargo = new Thread(() -> {
            try {
                System.out.println("Hilo largo iniciado...");
                Thread.sleep(5000);
                System.out.println("Hilo largo terminado.");
            } catch (InterruptedException e) {
                System.out.println("Hilo largo interrumpido!");
            }
        });

        hiloLargo.start();
        System.out.println("Esperando al hilo largo con join...");
        hiloLargo.join(2000); // Espera solo 2 segundos

        if (hiloLargo.isAlive()) {
            System.out.println("El hilo sigue vivo, interrumpiendo...");
            hiloLargo.interrupt();
        }
    }
}
