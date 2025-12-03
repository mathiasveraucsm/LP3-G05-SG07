package ejercicio2;

public class DescuentoFijo implements Descuento {
	
	@Override
	public double calcularPrecioFinal(Producto[] productos) {
		
		double total = 0;
		for (Producto p : productos) total += p.getPrecio();
		return total * 0.9; 
		
	}
}