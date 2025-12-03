package actividad1_strategy;


public class Strategy {
	
	public static void main(String[] args) {
		Producto p1 = new Producto("Laptop", 1000);

		p1.setPromocion(new PromocionPorcentaje(10));
		p1.mostrarPrecioFinal();

		p1.setPromocion(new PromocionMontoFijo(200));
		p1.mostrarPrecioFinal();
		
	}
}
