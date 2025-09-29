package exp1;

class InvalidSubscriptException extends RuntimeException {
    public InvalidSubscriptException(String mensaje) {
        super(mensaje);
    }
}

public class main {

    public static void main(String[] args) {
        Integer[] arregloInteger = { 1, 2, 3, 4, 5, 6 };
        Double[] arregloDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] arregloCharacter = { 'H', 'O', 'L', 'A' };

        System.out.println("El arreglo arregloInteger contiene:");
        imprimirArreglo(arregloInteger);

        System.out.println("\nEl arreglo arregloDouble contiene:");
        imprimirArreglo(arregloDouble);

        System.out.println("\nEl arreglo arregloCharacter contiene:");
        imprimirArreglo(arregloCharacter);

        System.out.println("\n\nEl arreglo arregloInteger (parcial) contiene:");
        try {
            int cantidad = imprimirArreglo(arregloInteger, 1, 4);
            System.out.println("\nElementos impresos: " + cantidad);
        } catch (InvalidSubscriptException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static <T> void imprimirArreglo(T[] arregloEntrada) {
        for (T elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    }

    public static <T> int imprimirArreglo(T[] arregloEntrada, int subindiceInferior, int subindiceSuperior) {
        if (subindiceInferior < 0 || subindiceSuperior >= arregloEntrada.length || subindiceSuperior <= subindiceInferior) {
            throw new InvalidSubscriptException("Índices inválidos: [" + subindiceInferior + ", " + subindiceSuperior + "]");
        }

        int contador = 0;
        for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
            contador++;
        }
        System.out.println();
        return contador;
    }
}
