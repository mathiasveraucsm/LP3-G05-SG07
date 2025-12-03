package ejercicio2;


public class DescuentoPorcentualAcumulado implements Descuento {
	
	@Override
	public double calcularPrecioFinal(Producto[] productos) {
		double total = 0;
		double menorPrecio = Double.MAX_VALUE;

		for (Producto p : productos) {
			total += p.getPrecio();
			if (p.getPrecio() < menorPrecio) menorPrecio = p.getPrecio();
		}

		if (productos.length >= 3) {
			total -= menorPrecio * 0.5; 
		}

     return total;
     
	}
}