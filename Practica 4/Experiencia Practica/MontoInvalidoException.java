package experienciaPractica;

public class MontoInvalidoException extends IllegalArgumentException {
    public MontoInvalidoException(String mensaje) {
        super(mensaje);
    }
}