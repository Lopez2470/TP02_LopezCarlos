package ar.edu.unju.fi.ejercicio6.model;

public class FelinoSalvaje {
	private String nombre;
	private int edad;
	private float peso;
	
	public FelinoSalvaje() {
		// TODO Auto-generated constructor stub
	}

	public FelinoSalvaje(String nombre, int edad, float peso) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "FelinoSalvaje [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
	}
	
	

}
