package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;

	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}

	public PagoTarjeta(String numTarjeta, LocalDate fechaPago, double montoPagado) {
		this.numTarjeta = numTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	// Formatear la fecha de pago
	public String mostrarFechaFormateada() {
		String fechaSalida;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
		return fechaSalida = this.fechaPago.format(dtf);
	}

	@Override
	public void realizarPago(double monto) {
		this.montoPagado = monto + monto * RECARGO_15;

	}

	@Override
	public void imprimirRecibo() {
		System.out.printf("Número de Tarjeta: %s\nFecha de Pago: %s\nMonto Pagado: $%.2f\n", this.numTarjeta,
				mostrarFechaFormateada(), this.montoPagado);

	}

}
