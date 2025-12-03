package actividad1_strategy;

public class PromocionMontoFijo implements Promocion {
	
	private double monto;

	public PromocionMontoFijo(double monto) {
		this.monto = monto;
	}

	@Override
	public double aplicarDescuento(double precio) {
		return precio - monto;
	}
	
}