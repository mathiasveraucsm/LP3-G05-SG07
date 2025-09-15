package experienciaPractica;

public class SaldoInsuficienteException extends IllegalArgumentException {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}