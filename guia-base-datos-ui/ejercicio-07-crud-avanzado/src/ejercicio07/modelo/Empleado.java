package ejercicio07.modelo;

public class Empleado {

    private int id;
    private String nombre;
    private int idDepartamento;
    private String nombreDepartamento;
    private String foto;

    public Empleado() {
    }

    public Empleado(String nombre, int idDepartamento, String foto) {
        this.nombre = nombre;
        this.idDepartamento = idDepartamento;
        this.foto = foto;
    }

    public Empleado(int id, String nombre, int idDepartamento, String nombreDepartamento, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
