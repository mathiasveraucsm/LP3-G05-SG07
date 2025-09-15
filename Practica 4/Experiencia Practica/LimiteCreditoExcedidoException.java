package experienciaPractica;

public class LimiteCreditoExcedidoException extends IllegalArgumentException {
    public LimiteCreditoExcedidoException(String mensaje) {
        super(mensaje);
    }
}
