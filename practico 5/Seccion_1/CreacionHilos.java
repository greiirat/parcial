class TareaHilo extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " - Numero: " + i);
        }
    }
}

class TareaRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " (Runnable) - Numero: " + i);
        }
    }
}

public class CreacionHilos {
    public static void main(String[] args) {
        // Ejercicio 1.1
        TareaHilo hilo1 = new TareaHilo();
        TareaHilo hilo2 = new TareaHilo();
        hilo1.start();
        hilo2.start();

        // Ejercicio 1.2
        Thread hilo3 = new Thread(new TareaRunnable());
        hilo3.start();
    }
}
