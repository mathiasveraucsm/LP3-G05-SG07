package ejercicio1;

public class VocalException extends Exception {
    public VocalException(char c) {
        super("Error: Se ingresó una vocal -> '" + c + "'");
    }
}
