package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		System.out.printf("%s \t\t%s \t%s \t%s\n", "Provincia","Poblacion","Superficie","Densidad(km2)");
		for (Provincia provincia: Provincia.values()) {
			System.out.printf("%-18s\t%8d\t%10d\t\t%5.2f\n",provincia, provincia.getPoblacion(),
								provincia.getSuperficie(),provincia.calcularDensidad());
		}

	}

}
