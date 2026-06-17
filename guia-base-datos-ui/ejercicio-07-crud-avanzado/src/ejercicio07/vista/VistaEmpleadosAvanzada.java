package ejercicio07.vista;

import ejercicio07.dao.DepartamentoDAO;
import ejercicio07.dao.EmpleadoDAO;
import ejercicio07.modelo.Departamento;
import ejercicio07.modelo.Empleado;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class VistaEmpleadosAvanzada extends JFrame {

    private final EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private final DepartamentoDAO departamentoDAO = new DepartamentoDAO();

    private final JTextField txtId = new JTextField(10);
    private final JTextField txtNombre = new JTextField(20);
    private final JComboBox<Departamento> comboDepartamento = new JComboBox<>();
    private final JLabel lblPreview = new JLabel("Sin foto", JLabel.CENTER);
    private final DefaultTableModel modeloTabla;
    private final JTable tabla;

    private String rutaFotoActual = "";
    private List<Empleado> empleados;

    public VistaEmpleadosAvanzada() {
        setTitle("CRUD Avanzado - Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450);
        setLocationRelativeTo(null);

        txtId.setEditable(false);
        lblPreview.setPreferredSize(new Dimension(120, 120));

        JPanel panelFormulario = new JPanel(new GridLayout(7, 2, 5, 5));
        panelFormulario.add(new JLabel("ID:"));
        panelFormulario.add(txtId);
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Departamento:"));
        panelFormulario.add(comboDepartamento);
        panelFormulario.add(new JLabel("Foto:"));

        JButton btnBuscarFoto = new JButton("Buscar Foto");
        panelFormulario.add(btnBuscarFoto);
        panelFormulario.add(new JLabel("Vista previa:"));
        panelFormulario.add(lblPreview);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar");
        panelFormulario.add(btnAgregar);
        panelFormulario.add(btnModificar);
        panelFormulario.add(new JLabel());
        panelFormulario.add(btnEliminar);

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Departamento", "Foto"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tabla);

        add(panelFormulario, BorderLayout.WEST);
        add(scrollTabla, BorderLayout.CENTER);

        cargarDepartamentos();
        cargarTabla();

        btnBuscarFoto.addActionListener(e -> buscarFoto());
        btnAgregar.addActionListener(e -> agregarEmpleado());
        btnModificar.addActionListener(e -> modificarEmpleado());
        btnEliminar.addActionListener(e -> eliminarEmpleado());

        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tabla.getSelectedRow();
                if (fila >= 0) {
                    int id = (int) modeloTabla.getValueAt(fila, 0);
                    empleados.stream()
                            .filter(emp -> emp.getId() == id)
                            .findFirst()
                            .ifPresent(VistaEmpleadosAvanzada.this::cargarEmpleadoEnFormulario);
                }
            }
        });
    }

    private void cargarDepartamentos() {
        comboDepartamento.removeAllItems();
        for (Departamento departamento : departamentoDAO.consultarTodos()) {
            comboDepartamento.addItem(departamento);
        }
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        empleados = empleadoDAO.consultarTodos();
        for (Empleado empleado : empleados) {
            modeloTabla.addRow(new Object[]{
                empleado.getId(),
                empleado.getNombre(),
                empleado.getNombreDepartamento(),
                empleado.getFoto() != null ? empleado.getFoto() : ""
            });
        }
    }

    private void cargarEmpleadoEnFormulario(Empleado empleado) {
        txtId.setText(String.valueOf(empleado.getId()));
        txtNombre.setText(empleado.getNombre());
        seleccionarDepartamento(empleado.getIdDepartamento());
        rutaFotoActual = empleado.getFoto() != null ? empleado.getFoto() : "";
        mostrarFoto(rutaFotoActual);
    }

    private void seleccionarDepartamento(int idDepartamento) {
        for (int i = 0; i < comboDepartamento.getItemCount(); i++) {
            Departamento departamento = comboDepartamento.getItemAt(i);
            if (departamento.getIdDepto() == idDepartamento) {
                comboDepartamento.setSelectedIndex(i);
                return;
            }
        }
    }

    private void buscarFoto() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter(
                "Imágenes", "jpg", "jpeg", "png", "gif", "bmp"
        ));

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            rutaFotoActual = archivo.getAbsolutePath();
            mostrarFoto(rutaFotoActual);
        }
    }

    private void mostrarFoto(String ruta) {
        if (ruta == null || ruta.isBlank()) {
            lblPreview.setIcon(null);
            lblPreview.setText("Sin foto");
            return;
        }

        ImageIcon icono = new ImageIcon(ruta);
        Image imagen = icono.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        lblPreview.setIcon(new ImageIcon(imagen));
        lblPreview.setText("");
    }

    private Empleado leerEmpleadoDesdeFormulario() {
        Departamento departamento = (Departamento) comboDepartamento.getSelectedItem();
        if (departamento == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un departamento.");
            return null;
        }

        if (txtNombre.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del empleado.");
            return null;
        }

        Empleado empleado = new Empleado(
                txtNombre.getText(),
                departamento.getIdDepto(),
                rutaFotoActual.isBlank() ? null : rutaFotoActual
        );

        if (!txtId.getText().isBlank()) {
            empleado.setId(Integer.parseInt(txtId.getText()));
        }

        return empleado;
    }

    private void agregarEmpleado() {
        txtId.setText("");
        Empleado empleado = leerEmpleadoDesdeFormulario();
        if (empleado == null) {
            return;
        }

        empleadoDAO.insertar(empleado);
        cargarTabla();
        limpiarCampos();
    }

    private void modificarEmpleado() {
        if (txtId.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado de la tabla.");
            return;
        }

        Empleado empleado = leerEmpleadoDesdeFormulario();
        if (empleado == null) {
            return;
        }

        empleadoDAO.modificar(empleado);
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
            empleadoDAO.eliminar(Integer.parseInt(txtId.getText()));
            cargarTabla();
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        comboDepartamento.setSelectedIndex(0);
        rutaFotoActual = "";
        mostrarFoto("");
    }
}
