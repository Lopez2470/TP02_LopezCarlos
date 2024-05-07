package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaDeNacimiento;
	private String nacionalidad;
	private float estatura;
	private float peso;
	private Posicion posicion;
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public Jugador(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, float estatura,
			float peso, Posicion posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public void mostrarTituloJugador() {
		System.out.printf("%s \t\t%s \t%s \t%s \t%s \t%s \t%s \t%s\n", 
				"Nombre","Apellido","Edad","Fecha Nac.","Nacionalidad", "Estatura", "Peso","Posicion" );
	}
	public void mostrarJugador() {	
		System.out.printf("%-10s \t%10s \t%4d \t%10s \t%10s \t%5.2f \t\t%5.2f \t%10s\n",
				this.nombre, this.apellido, calcularEdad(), mostrarFechaFormateada(),
				this.nacionalidad,this.estatura, this.peso, this.posicion);
	}
	
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", fechaDeNacimiento=" + fechaDeNacimiento
				+ ", nacionalidad=" + nacionalidad + ", estatura=" + estatura + ", peso=" + peso + ", posicion="
				+ posicion + "]";
	}

	//Calcular edad
	public int calcularEdad() {
		return Period.between(fechaDeNacimiento,LocalDate.now()).getYears();
	}
	
	//Formatear la fecha de nacimiento
	public String mostrarFechaFormateada() {
		String fechaSalida;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return fechaSalida = fechaDeNacimiento.format(dtf);	
	}

}
