package ejercicio2;


import java.util.Scanner;

public class CalculadoraDePrecios {
	
	public static void main(String[] args) {
	 
		Scanner sc = new Scanner(System.in);

		Producto[] productos = {
				new Producto("Laptop", 1000),
				new Producto("Laptop", 1000),
				new Producto("Mouse", 50)
		};

		System.out.println("Seleccione estrategia de descuento:");
		System.out.println("1. Sin Descuento");
		System.out.println("2. Descuento Fijo (10%)");
		System.out.println("3. Descuento Porcentual (2 iguales → 30%)");
		System.out.println("4. Descuento Porcentual Acumulado (3+ → 50% en el más barato)");

		int opcion = sc.nextInt();
		Descuento descuento;

		switch (opcion) {
        	case 1: descuento = new SinDescuento(); break;
        	case 2: descuento = new DescuentoFijo(); break;
        	case 3: descuento = new DescuentoPorcentual(); break;
        	case 4: descuento = new DescuentoPorcentualAcumulado(); break;
        	default: descuento = new SinDescuento(); break;
		}

		double precioFinal = descuento.calcularPrecioFinal(productos);
		System.out.println("Precio final: " + precioFinal);
		
	}
}
