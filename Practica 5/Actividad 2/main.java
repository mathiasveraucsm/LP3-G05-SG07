package exp2;

public class main {
    public static void main(String[] args) {
        Pila<String> pila = new Pila<>(2);
        pila.push("Melgar");
        pila.push("Arequipa");

        System.out.println(pila.contains("Melgar"));  
        System.out.println(pila.contains("Cusco"));   

        try {
            pila.push("Perú"); 
        } catch (Pila.ExcepcionPilaLlena e) {
            System.out.println(e.getMessage());
        }

        pila.pop();
        pila.pop();

        try {
            pila.pop(); 
        } catch (Pila.ExcepcionPilaVacia e) {
            System.out.println(e.getMessage());
        }
    }
}