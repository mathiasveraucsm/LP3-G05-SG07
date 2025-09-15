package experienciaPractica;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    protected double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (saldoInicial < 0) throw new MontoInvalidoException("El saldo inicial no puede ser negativo.");
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto <= 0) throw new MontoInvalidoException("El monto debe ser positivo.");
        saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= 0) throw new MontoInvalidoException("El monto debe ser positivo.");
        if (monto > saldo) throw new SaldoInsuficienteException("Saldo insuficiente.");
        saldo -= monto;
    }

    public void transferir(CuentaBancaria destino, double monto) {
        if (destino == null) throw new CuentaNoEncontradaException("Cuenta destino no encontrada.");
        this.retirar(monto);
        destino.depositar(monto);
    }

    public double consultarSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }
}