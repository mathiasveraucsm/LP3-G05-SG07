package ejercicio1;

public class main {
	 public static void main(String[] args) {
	        LeerEntrada entrada = new LeerEntrada(System.in);
	        System.out.print("Ingrese un carácter: ");

	        try {
	            char c = entrada.getChar();
	            entrada.procesar(c);
	            System.out.println("Carácter válido: " + c);
	        } catch (VocalException | NumeroException | EspacioException | SimboloException e) {
	            System.out.println(e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Error inesperado: " + e.getMessage());
	        }
	    }


}
