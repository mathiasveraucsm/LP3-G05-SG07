interface Imprimible {
 void imprimir(String documento);
}

interface Escaneable {
 void escanear(String documento);
}

class Impresora implements Imprimible {
 @Override
 public void imprimir(String documento) {
     System.out.println("Imprimiendo: " + documento);
 }
}

class ImpresoraMultifuncional implements Imprimible, Escaneable {
 @Override
 public void imprimir(String documento) {
     System.out.println("Imprimiendo multifuncional: " + documento);
 }

 @Override
 public void escanear(String documento) {
     System.out.println("Escaneando: " + documento);
 }
}

public class main {
 public static void main(String[] args) {
     Imprimible impresoraSimple = new Impresora();
     impresoraSimple.imprimir("Documento A");

     ImpresoraMultifuncional multifuncional = new ImpresoraMultifuncional();
     multifuncional.imprimir("Documento B");
     multifuncional.escanear("Documento B");
 }
}
