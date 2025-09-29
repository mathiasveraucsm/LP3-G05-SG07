package exp4;

public class main {
    public static void main(String[] args) {
        Pila<String> pila1 = new Pila<>();
        Pila<String> pila2 = new Pila<>();

        pila1.push("Melgar");
        pila1.push("Arequipa");

        pila2.push("Melgar");
        pila2.push("Arequipa");

        System.out.println(pila1.esIgual(pila2)); 

        pila2.pop();
        pila2.push("Cusco");

        System.out.println(pila1.esIgual(pila2)); 
    }
}