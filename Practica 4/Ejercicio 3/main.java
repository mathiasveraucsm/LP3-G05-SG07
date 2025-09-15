package ejercicio3;

public class main {
	 public static void main(String[] args) {
	        try {
	            Numero n1 = new Numero(25.5);
	            System.out.println("Valor inicial: " + n1.getValor());

	            n1.setValor(-10);
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: " + e.getMessage());
	        }

	        try {
	            Numero n2 = new Numero(-5); 
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error al crear número: " + e.getMessage());
	        }
	    }

}
