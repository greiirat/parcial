package ejercicio07;

import ejercicio07.vista.VistaEmpleadosAvanzada;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaEmpleadosAvanzada vista = new VistaEmpleadosAvanzada();
            vista.setVisible(true);
        });
    }
}
