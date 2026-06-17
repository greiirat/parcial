public class Usuario {
    private String nombre;
    private int edad;
    private String correo;
    private int telefono;

        public static void main(String[] args) {
            Usuario usuario1 = new Usuario("Juan");
            usuario1.actualizarPerfil("juan@example.com");
        }
    
    // Ejercicio 2.2
    public Usuario() { }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Sobrecarga de Métodos
    public void actualizarPerfil(String correo) {
        this.correo = correo;
        System.out.println("Correo actualizado.");
    }

    public void actualizarPerfil(String correo, int telefono) {
        this.correo = correo;
        this.telefono = telefono;
        System.out.println("Correo y teléfono actualizados.");
    }
}
