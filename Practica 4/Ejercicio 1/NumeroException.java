package ejercicio1;

public class NumeroException extends Exception {
    public NumeroException(char c) {
        super("Error: Se ingresó un número -> '" + c + "'");
    }
}