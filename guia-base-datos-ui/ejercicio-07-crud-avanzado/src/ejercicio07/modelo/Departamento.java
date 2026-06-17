package ejercicio07.modelo;

public class Departamento {

    private int idDepto;
    private String nombreDepto;

    public Departamento() {
    }

    public Departamento(int idDepto, String nombreDepto) {
        this.idDepto = idDepto;
        this.nombreDepto = nombreDepto;
    }

    public int getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(int idDepto) {
        this.idDepto = idDepto;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    @Override
    public String toString() {
        return nombreDepto;
    }
}
