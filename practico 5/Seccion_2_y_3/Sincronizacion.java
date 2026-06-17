class Contador {
    private int cuenta = 0;

    public void incrementar() {
        cuenta++;
    }

    public synchronized void incrementarSincronizado() {
        cuenta++;
    }

    public void incrementarBloque() {
        synchronized(this) {
            cuenta++;
        }
    }

    public int getCuenta() {
        return cuenta;
    }
    
    public void reset() {
        cuenta = 0;
    }
}

public class Sincronizacion {
    public static void main(String[] args) throws InterruptedException {
        // Ejercicio 2.1
        Contador contador = new Contador();

        Runnable tarea = () -> {
            for (int i = 0; i < 10000; i++) {
                contador.incrementar();
            }
        };

        Thread t1 = new Thread(tarea);
        Thread t2 = new Thread(tarea);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Cuenta sin sincronizar (puede fallar): " + contador.getCuenta());

        // Ejercicio 3.1
        contador.reset();
        Runnable tareaSync = () -> {
            for (int i = 0; i < 10000; i++) {
                contador.incrementarSincronizado();
            }
        };

        Thread t3 = new Thread(tareaSync);
        Thread t4 = new Thread(tareaSync);
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("Cuenta sincronizada: " + contador.getCuenta());
    }
}
