package ejercicio1;

public class EspacioException extends Exception {
    public EspacioException() {
        super("Error: Se ingresó un espacio en blanco");
    }
}