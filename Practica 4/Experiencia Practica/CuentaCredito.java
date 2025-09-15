package experienciaPractica;

public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) {
        super(numeroCuenta, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) throw new MontoInvalidoException("El monto debe ser positivo.");
        if (monto > saldo + limiteCredito) throw new LimiteCreditoExcedidoException("Límite de crédito excedido.");
        saldo -= monto;
    }
}