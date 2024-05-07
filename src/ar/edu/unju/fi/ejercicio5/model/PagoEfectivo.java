package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	private double montoPagado;
	private LocalDate fechaPago;

	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}

	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	//Formatear la fecha de pago
		public String mostrarFechaFormateada() {
			String fechaSalida;
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
			return fechaSalida = this.fechaPago.format(dtf);	
		}

	@Override
	public void realizarPago(double monto) {
		this.montoPagado= monto - monto*DESCUENTO_10;

	}

	@Override
	public void imprimirRecibo() {
		System.out.printf("Fecha de Pago: %s\nMonto Pagado: $%.2f\n", mostrarFechaFormateada(), this.montoPagado );

	}

}
