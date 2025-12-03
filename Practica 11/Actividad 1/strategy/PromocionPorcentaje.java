package actividad1_strategy;

public class PromocionPorcentaje implements Promocion {
	
	private double porcentaje;

	public PromocionPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public double aplicarDescuento(double precio) {
		return precio - (precio * porcentaje / 100);
	}
	
}