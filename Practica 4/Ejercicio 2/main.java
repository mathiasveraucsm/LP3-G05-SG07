package ejercicio2;

public class main {
	public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        try {
            double resultado1 = calc.sumar(47.5, 7);
            System.out.println("Suma: " + resultado1);

            double resultado2 = calc.restar(17, 54);
            System.out.println("Resta: " + resultado2);

            double resultado3 = calc.multiplicar(120.15, 5);
            System.out.println("Multiplicación: " + resultado3);

            double resultado4 = calc.dividir(10, 0); 
            System.out.println("División: " + resultado4);

        } catch (IllegalArgumentException e) {
            System.out.println("Argumento inválido: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }
    }

}
