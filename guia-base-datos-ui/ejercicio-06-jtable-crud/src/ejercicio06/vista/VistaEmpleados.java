package ejercicio06.vista;

import ejercicio06.dao.EmpleadoDAO;
import ejercicio06.modelo.Empleado;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VistaEmpleados extends JFrame {

    private final EmpleadoDAO dao = new EmpleadoDAO();
    private final JTextField txtId = new JTextField(10);
    private final JTextField txtNombre = new JTextField(20);
    private final JTextField txtDepartamento = new JTextField(20);
    private final DefaultTableModel modeloTabla;
    private final JTable tabla;

    public VistaEmpleados() {
        setTitle("Gestión de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);

        txtId.setEditable(false);

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 5, 5));
        panelFormulario.add(new JLabel("ID:"));
        panelFormulario.add(txtId);
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Departamento:"));
        panelFormulario.add(txtDepartamento);

        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar");
        panelFormulario.add(btnModificar);
        panelFormulario.add(btnEliminar);

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Departamento"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tabla);

        add(panelFormulario, BorderLayout.WEST);
        add(scrollTabla, BorderLayout.CENTER);

        cargarTabla();

        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tabla.getSelectedRow();
                if (fila >= 0) {
                    txtId.setText(String.valueOf(tabla.getValueAt(fila, 0)));
                    txtNombre.setText(String.valueOf(tabla.getValueAt(fila, 1)));
                    txtDepartamento.setText(String.valueOf(tabla.getValueAt(fila, 2)));
                }
            }
        });

        btnModificar.addActionListener(e -> modificarEmpleado());
        btnEliminar.addActionListener(e -> eliminarEmpleado());
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        for (Empleado empleado : dao.consultarTodos()) {
            modeloTabla.addRow(new Object[]{
                empleado.getId(),
                empleado.getNombre(),
                empleado.getDepartamento()
            });
        }
    }

    private void modificarEmpleado() {
        if (txtId.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado de la tabla.");
            return;
        }

        Empleado empleado = new Empleado(
                Integer.parseInt(txtId.getText()),
                txtNombre.getText(),
                txtDepartamento.getText()
        );
        dao.modificar(empleado);
        cargarTabla();
        limpiarCampos();
    }

    private void eliminarEmpleado() {
        if (txtId.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado de la tabla.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Eliminar el empleado seleccionado?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            dao.eliminar(Integer.parseInt(txtId.getText()));
            cargarTabla();
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtDepartamento.setText("");
    }
}
