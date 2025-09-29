package ejercicio;

public class Par<F, S> {

    private F primero;
    private S segundo;

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() {
        return primero;
    }

    public S getSegundo() {
        return segundo;
    }

    public void setPrimero(F primero) {
        this.primero = primero;
    }

    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    public boolean esIgual(Par<F, S> otro) {
        if (otro == null) return false;

        boolean primeroIgual = (primero == null && otro.primero == null) || (primero != null && primero.equals(otro.primero));

        boolean segundoIgual = (segundo == null && otro.segundo == null) || (segundo != null && segundo.equals(otro.segundo));

        return primeroIgual && segundoIgual;
    }

    @Override
    public String toString() {
        return String.format("(Primero: %s, Segundo: %s)", primero, segundo);
    }
}