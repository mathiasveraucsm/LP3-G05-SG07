package ejercicio2;


public class DescuentoPorcentual implements Descuento {
	
	@Override
	public double calcularPrecioFinal(Producto[] productos) {
		
		if (productos.length == 2 && productos[0].getNombre().equals(productos[1].getNombre())) {
			return (productos[0].getPrecio() + productos[1].getPrecio()) * 0.7; 
		}
		
		double total = 0;
		for (Producto p : productos) total += p.getPrecio();
		return total;
		
	}

}
