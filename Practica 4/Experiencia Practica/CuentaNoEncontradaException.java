package experienciaPractica;

public class CuentaNoEncontradaException extends IllegalArgumentException {
    public CuentaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}