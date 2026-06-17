class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

class ProductoInvalidoException extends RuntimeException {
    public ProductoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class Cuenta {
    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("No tienes saldo suficiente.");
        }
        saldo -= monto;
        System.out.println("Retiro exitoso. Saldo restante: " + saldo);
    }
}

class Producto {
    public Producto(double precio) {
        if (precio <= 0) {
            throw new ProductoInvalidoException("El precio debe ser mayor a cero.");
        }
        System.out.println("Producto creado con precio: " + precio);
    }
}

public class ExcepcionesPersonalizadas {
    public static void main(String[] args) {
        // Ejercicio 3.1
        Cuenta miCuenta = new Cuenta(100);
        try {
            miCuenta.retirar(200);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error de cuenta: " + e.getMessage());
        }

        // Ejercicio 3.2
        new Producto(-10);
    }
}
