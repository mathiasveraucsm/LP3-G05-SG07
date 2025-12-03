package actividad1_strategy;

public class Producto {
	
	private String nombre;
	private double precio;
	private Promocion promocion;

	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
		this.promocion = new SinPromocion();
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}

	public void mostrarPrecioFinal() {
		System.out.println(nombre + " precio final: " + promocion.aplicarDescuento(precio));
	}
	
}
