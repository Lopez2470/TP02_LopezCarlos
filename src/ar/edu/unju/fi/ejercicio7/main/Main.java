package ar.edu.unju.fi.ejercicio7.main;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio7.model.Producto;
import ar.edu.unju.fi.ejercicio7.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio7.util.Listado;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		byte opcion = 0;

		while (opcion != 7) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("                         MENU");
			System.out.println("---------------------------------------------------------------------");
			System.out.println("1- Mostrar productos disponibles");
			System.out.println("2- Mostrar productos faltantes");
			System.out.println("3- Incrementar los precios de los productos en un 20%");
			System.out.println("4- Mostrar los productos que corresponden a la categoría Electrohogar ");
			System.out.println("   y estén disponibles para la venta");
			System.out.println("5- Ordenar los productos por precio de forma descendente.");
			System.out.println("6- Mostrar los productos con los nombres en mayúsculas.");
			System.out.println("7- Salir.");
			System.out.println("---------------------------------------------------------------------");
			System.out.print("Ingrese una opcion: ");
			

			try {
				opcion = scanner.nextByte();
				scanner.nextLine();

				switch (opcion) {
				case 1:

					mostrarProductosDisponibles(Listado.getListadoProductos());

					break;
				case 2:
					 mostrarProductosFaltantes(Listado.getListadoProductos());
					 
					break;
				case 3:
					incrementarPreciosDeProductos(Listado.getListadoProductos());
					break;
				case 4:
					 mostrarProductosPorCondicion(Listado.getListadoProductos());
					break;
				case 5:
					ordenarProductosPorPrecio(Listado.getListadoProductos());
					break;
				case 6:
					mostrarEnMayusculas(Listado.getListadoProductos());
					break;
				case 7:
					System.out.println("Salida del Menu");
					break;
				default:
					System.out.println("Error: Ingrese una opcion correcta: [1-5].");
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar numeros enteros.");
				scanner.nextLine();
			} finally {


			}
		}
		scanner.close();
	}

	// Mostrar productos
	public static void mostrarProductosDisponibles(List<Producto> productos) {
		System.out.println("---------------------------------------------------");
		System.out.println("           Lista de productos Disponibles:");
		System.out.println("----------------------------------------------------");
	
		Listado.mostrarDetalle();
		Consumer<Producto> mostrar = p -> {
			   if (p.isDisponible()) 
				   p.mostrarDetalle();
				  // System.out.println(p);
		   };
		   productos.forEach(mostrar);
	}
	//Mostrar productos Faltantes
	public static void mostrarProductosFaltantes(List<Producto> productos) {
		Listado.mostrarDetalle();
		Predicate<Producto> condicion = p -> !p.isDisponible();
		productos.stream()
				.filter(condicion)
				.collect(Collectors.toList());	
		List<Producto> productosFaltantes = productos.stream().filter(condicion).collect(Collectors.toList());
	
		Consumer<Producto> mostrar = p -> p.mostrarDetalle();
		productosFaltantes.forEach(mostrar);		
	}
	
	//Aumentar precio productos
	public static void incrementarPreciosDeProductos(List<Producto> productos) {
		Listado.mostrarDetalle();
		
		
		Function<Producto, Producto> nuevoPrecio = (p) -> {
			p.setPrecioUnitario(p.getPrecioUnitario()*1.20f);
			return p;};
		List<Producto> productoInc = productos.stream().map(nuevoPrecio).collect(Collectors.toList());
		productoInc.forEach(p -> p.mostrarDetalle());
		//prodIncremento.forEach(n -> n.MostrarDatos());
	}
	
	//Mostrar productos por condiciion
	public static void mostrarProductosPorCondicion(List<Producto> productos) {		
		Listado.mostrarDetalle();
		Predicate<Producto> condicion = p -> p.getCategoria().equals(Categoria.ELECTROHOGAR)
				&& p.isDisponible();
		List<Producto> productosLista = productos.stream().filter(condicion).collect(Collectors.toList());
		productosLista.forEach(p -> p.mostrarDetalle());				
	}
	
	//Ordenar productos por precio
	public static void ordenarProductosPorPrecio(List<Producto> productos) {
		Comparator<Producto> ordenP = Comparator.comparing(Producto::getPrecioUnitario).reversed();
		productos.sort(ordenP);
		Listado.mostrarDetalle();
		productos.forEach(p -> p.mostrarDetalle());
	}
	
	//Mostrar en mayusculas
	public static void mostrarEnMayusculas(List<Producto> productos) {
	Function<Producto, Producto> salida = p -> {
		p.setDescripcion(p.getDescripcion().toUpperCase());
		return p;
	};
	List<Producto> productosM = productos.stream().map(salida).collect(Collectors.toList());
	Listado.mostrarDetalle();
	productosM.forEach(p -> p.mostrarDetalle());		
	}	

}
