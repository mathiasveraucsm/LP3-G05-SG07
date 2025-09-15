package ejercicio1;

public class SimboloException extends Exception {
    public SimboloException(char c) {
        super("Error: Se ingresó un símbolo -> '" + c + "'");
    }
}