package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		//Garfield (Felino doméstico) está manifestando comportamientos salvajes, entonces vamos a realizar
		//la conversión a felino salvaje de la siguiente forma:
		
		FelinoDomestico felinoDomestico = new FelinoDomestico("Garfield", (byte)45, 12f);
		
		//definición de expresión lambda que define el convertidor de FelinoDomestico a
		//FelinoSalvaje.
		
		if (Converter.isNotNull(felinoDomestico)){
			Converter<FelinoDomestico, FelinoSalvaje> converter = x -> 
			new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());
			//se realiza la conversión
			FelinoSalvaje felinoSalvaje = converter.converter(felinoDomestico);
			//mostramos los datos del objeto felino salvaje felinoSalvaje
			converter.mostrarObjeto(felinoSalvaje);
		}else {
			System.out.println("El objeto felinoDomestico es null.");
		}
		
		//Realice la conversión de un objeto felino salvaje a felino doméstico.
		
		FelinoSalvaje otroFelinoSalvaje = new FelinoSalvaje("Tanner", (byte)20, 186f);
		if (Converter.isNotNull(otroFelinoSalvaje)) {
			Converter<FelinoSalvaje, FelinoDomestico> converter2 = x -> 
			new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
			
			FelinoDomestico felinoDomestico2 = converter2.converter(otroFelinoSalvaje);
			//mostramos los datos del objeto felino domestico felinoDomestico2
			converter2.mostrarObjeto(felinoDomestico2);
		}else {
			System.out.println("El objeto felinoSalvaje es null.");
		}
	}
}
