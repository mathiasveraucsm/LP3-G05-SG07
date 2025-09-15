package ejercicio2;

public class DivisionPorCeroException extends ArithmeticException {
    public DivisionPorCeroException() {
        super("Error: No se puede dividir por cero.");
    }
}
