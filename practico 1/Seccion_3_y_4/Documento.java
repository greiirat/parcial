// Ejercicio 3.1
public abstract class Documento {
    
    // Método abstracto: define el "qué" pero no el "cómo"
    public abstract void procesar();

    // Podemos tener métodos comunes también
    public void mostrarTipo() {
        System.out.println("Este es un documento contable.");
    }
}
