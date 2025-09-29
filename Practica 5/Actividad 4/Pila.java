package exp4;

import exp2.Pila.ExcepcionPilaLlena;
import exp2.Pila.ExcepcionPilaVacia;

public class Pila<E> {

    private final int tamanio;
    private int superior;
    private E[] elementos;

    public Pila() {
        this(10);
    }

 
    public Pila(int s) {
        tamanio = s > 0 ? s : 10;
        superior = -1;
        elementos = (E[]) new Object[tamanio];
    }

    public void push(E valorAMeter) {
        if (superior == tamanio - 1)
            throw new ExcepcionPilaLlena(String.format("La Pila está llena, no se puede meter %s", valorAMeter));
        elementos[++superior] = valorAMeter;
    }

    public E pop() {
        if (superior == -1)
            throw new ExcepcionPilaVacia("Pila vacía, no se puede sacar");
        return elementos[superior--];
    }

    public boolean contains(E elemento) {
        for (int i = superior; i >= 0; i--) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public static class ExcepcionPilaLlena extends RuntimeException {
        public ExcepcionPilaLlena(String mensaje) {
            super(mensaje);
        }
    }

    public static class ExcepcionPilaVacia extends RuntimeException {
        public ExcepcionPilaVacia(String mensaje) {
            super(mensaje);
        }
    }
    
    public boolean esIgual(Pila<E> otraPila) {
        if (this.superior != otraPila.superior) {
            return false; 
        }

        for (int i = 0; i <= superior; i++) {
            E elem1 = this.elementos[i];
            E elem2 = otraPila.elementos[i];

            if (elem1 == null && elem2 == null) continue;
            if (elem1 == null || elem2 == null) return false;
            if (!elem1.equals(elem2)) return false;
        }

        return true;
    }
}