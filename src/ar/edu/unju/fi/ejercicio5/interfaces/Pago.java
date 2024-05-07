package ar.edu.unju.fi.ejercicio5.interfaces;

public interface Pago {
	public void realizarPago(double monto);
	public void imprimirRecibo();
	
	public final Double  DESCUENTO_10 = 0.10;
	public final Double  RECARGO_15 = 0.15;

}
