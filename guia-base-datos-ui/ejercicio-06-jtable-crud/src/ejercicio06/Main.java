package ejercicio06;

import ejercicio06.vista.VistaEmpleados;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaEmpleados vista = new VistaEmpleados();
            vista.setVisible(true);
        });
    }
}
