package ejercicio2;

public class main {

	public static void main(String[] args) {
		Forma[] formas = {
			    new Circulo(),
			    new Rectangulo(),
			    new Triangulo()
			};

			for (Forma f : formas) {
			    f.dibujar();
			    System.out.println(); 
			}

	}

}
