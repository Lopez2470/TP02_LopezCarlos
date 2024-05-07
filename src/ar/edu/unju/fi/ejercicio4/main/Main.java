package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.util.Listado;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		byte opcion = 0;

		while (opcion != 5) {
			System.out.println("------------------------");
			System.out.println("          MENU");
			System.out.println("------------------------");
			System.out.println("1- Alta de Jugador");
			System.out.println("2- Mostrar todos los Jugadores");
			System.out.println("3- Modificar la posicion de un jugador");
			System.out.println("4- Eliminar un jugador");
			System.out.println("5- Salir");
			System.out.print("Ingrese una opción: ");

			try {
				opcion = scanner.nextByte();
				scanner.nextLine();

				switch (opcion) {
				case 1:
					if (crearJugador(Listado.listadoJugadores)) {
						System.out.println("--------------------------------------");
						System.out.println("Jugador creado correctamente.");
						System.out.println("Jugadores dados de alta: " + Listado.listadoJugadores.size());
						System.out.println("--------------------------------------");
					} else {
						System.out.println("Error al dar de alta un Jugador");
					}
					break;
				case 2:
					mostrarJugadores(Listado.listadoJugadores);
					break;
				case 3:
					modificarPosicionJugador(Listado.listadoJugadores);
					break;
				case 4:
					eliminarJugador(Listado.listadoJugadores);
					break;
				case 5:
					System.out.println("Salida del Menu");
					break;
				default:
					System.out.println("Error: Ingrese una opcion correcta: [1-5].");
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar numeros enteros.");
				scanner.nextLine();
			} finally {
				// System.out.println(" Fin");

			}
		}
		scanner.close();
	}

	// Crear Jugador
	static Boolean crearJugador(List<Jugador> jugadores) {
		String nombre = ingresarNombre();
		String apellido = ingresarApellido();
		// Ingresar fecha de nacimiento
		/*
		 * int dia = ingresarDia(); int mes = ingresarMes(); int anio = ingresarAnio();
		 */
		LocalDate fechaDeNacimiento = LocalDate.of(ingresarAnio(), ingresarMes(), ingresarDia());
		// LocalDate fechaDeNacimiento = LocalDate.of(anio, mes, dia);
		String nacionalidad = ingresarNacionalidad();
		float estatura = ingresarEstatura();
		float peso = ingresarPeso();
		int posicionJugador = ingresarPosicion();
		// Asignar posicion
		Posicion posicion;
		posicion = Posicion.values()[posicionJugador - 1];
		// Crear Jugador
		Jugador jugador = new Jugador(nombre, apellido, fechaDeNacimiento, nacionalidad, estatura, peso, posicion);
		// Agregar al listado de jugadores
		return jugadores.add(jugador);
	}

	// Ingreso de nombre
	static String ingresarNombre() {
		String nombre = "";
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Ingrese el nombre de jugador: ");
			try {
				nombre = scanner.nextLine();
				if (nombre.isBlank()) {
					System.out.println("Error: Debe ingresar un nombre");
				} else {
					correcto = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar un nombre correcto");
				scanner.nextLine();
			}
		}
		return nombre;
	}

	// Ingreso de nombre
	static String ingresarApellido() {
		String apellido = "";
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Ingrese el apellido del jugador: ");
			try {
				apellido = scanner.nextLine();
				if (apellido.isBlank()) {
					System.out.println("Error: Debe ingresar un Apellido");
				} else {
					correcto = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar un apellido correcto");
				scanner.nextLine();
			}
		}
		return apellido;
	}

	// Ingreso de fecha de nacimiento
	// Ingreso del dia
	static int ingresarDia() {
		int dia = 0;
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Ingrese el dia de nacimiento: ");
			try {
				dia = scanner.nextInt();
				if (dia < 1 || dia > 31) {
					System.out.println("Error: Debe ingresar un dia valido [1-31]");
				} else {
					correcto = true;
					scanner.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar el valor de un número");
				scanner.nextLine();
			}
		}
		return dia;
	}

	// Ingreso del mes
	static int ingresarMes() {
		int mes = 0;
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Ingrese el mes de nacimiento: ");
			try {
				mes = scanner.nextInt();
				if (mes < 1 || mes > 12) {
					System.out.println("Error: Debe ingresar un mes valido [1-12]");
				} else {
					correcto = true;
					scanner.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar el valor de un número");
				scanner.nextLine();
			}
		}
		return mes;
	}

	// Ingreso del año
	static int ingresarAnio() {
		int anio = 0;
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Ingrese el año de nacimiento: ");
			try {
				anio = scanner.nextInt();
				if (anio < 1970 || anio > 2024) {
					System.out.println("Error: Debe ingresar un año valido [1970-2024]");
				} else {
					correcto = true;
					scanner.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar el valor de un número");
				scanner.nextLine();
			}
		}
		return anio;
	}

	// ingresar nacionalidad
	// Ingreso de nombre
	static String ingresarNacionalidad() {
		String nacionalidad = "";
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Ingrese nacionalidad del jugador: ");
			try {
				nacionalidad = scanner.nextLine();
				if (nacionalidad.isBlank()) {
					System.out.println("Error: Debe ingresar una nacionalidad");
				} else {
					correcto = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar una nacionalidad correcto");
				// scanner.nextLine();
			}
		}
		return nacionalidad;
	}

	// Ingreso de estatura
	static float ingresarEstatura() {
		float altura = 0;
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Ingrese estatura: ");
			try {
				altura = scanner.nextFloat();
				if (altura < 1 || altura > 230) {
					System.out.println("Error: Debe ingresar una estatura valida");
				} else {
					correcto = true;
					scanner.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar el valor de un número");
				scanner.nextLine();
			}
		}
		return altura;
	}

	// Ingreso del peso
	static float ingresarPeso() {
		float peso = 0;
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Ingrese el peso: ");
			try {
				peso = scanner.nextFloat();
				if (peso < 1 || peso > 200) {
					System.out.println("Error: Debe ingresar un peso correcto");
				} else {
					correcto = true;
					scanner.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar el valor de un número");
				scanner.nextLine();
			}
		}
		return peso;
	}

	// Ingreso de Mes
	static int ingresarPosicion() {
		int posicion = 0;
		boolean correcto = false;
		while (!correcto) {
			System.out.println("-------Posicion en la cancha--------");
			System.out.println("1- Delantero");
			System.out.println("2- Medio");
			System.out.println("3- Defensa");
			System.out.println("4- Arquero");
			System.out.println("Ingrese posicion del jugador [1-4]: ");
			try {
				posicion = scanner.nextInt();
				if (posicion < 1 || posicion > 4) {
					System.out.println("Error: Debe seleccionar una posicion valida [1-4]");
				} else {
					correcto = true;
					scanner.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar el valor de un número");
				scanner.nextLine();
			}
		}
		return posicion;
	}

	// Mostrar Jugadores

	private static void mostrarJugadores(List<Jugador> jugadores) {
		if (jugadores.isEmpty()) {
			System.out.println("No hay Jugadores registrados.");
		} else {
			System.out.println("---------------------------------");
			System.out.println("       Lista de Jugadores:");
			System.out.println("---------------------------------");
			System.out.printf("%s \t\t%s \t%s \t%s \t%s \t%s \t%s \t%s\n", 
					"Nombre","Apellido","Edad","Fecha Nac.","Nacionalidad", "Estatura", "Peso","Posicion" );
			for (Jugador jugador : jugadores) {
				jugador.mostrarJugador();
			}
		}

		// jugadores.forEach(j->System.out.println(j));
	}

	private static void modificarPosicionJugador(List<Jugador> jugadores) {
		if (jugadores.isEmpty()) {
			System.out.println("No hay jugadores registrados.");
		} else {
			// Ingresar el jugador a modificar
			System.out.println("---------------------------");
			System.out.println("Modificar Posicion del Jugador");
			System.out.println("---------------------------");
			String nombre = ingresarNombre();
			String apellido = ingresarApellido();
			// Buscar jugador
			Jugador jugadorBuscado = buscarJugador(nombre, apellido, jugadores);
			if (jugadorBuscado != null) {
				System.out.println("Jugador encontrado: " + jugadorBuscado.getApellido() + ", " + jugadorBuscado.getNombre());
				System.out.println("Posicion: " + jugadorBuscado.getPosicion());
				// modificar
				int posicionJugador = ingresarPosicion();
				// Asignar posicion
				Posicion posicion = Posicion.values()[posicionJugador - 1];
				jugadorBuscado.setPosicion(posicion);
				System.out.println("Posicion modificada del jugador");
			} else {
				System.out.println("Jugador no registrado.");
			}

		}

	}

	// Buscar jugador
	private static Jugador buscarJugador(String nombre, String apellido, List<Jugador> jugadores) {
		Jugador auxJugador = new Jugador();
		auxJugador = null;
		for (Jugador jugador : jugadores) {
			if (jugador.getApellido().equals(apellido) && jugador.getNombre().equals(nombre)) {
				auxJugador = jugador;
			}
		}
		return auxJugador;
	}

	private static void eliminarJugador(List<Jugador> jugadores) {
		if (jugadores.isEmpty()) {
			System.out.println("No hay jugadores registrados.");
		} else {
			// Ingresar el jugador a eliminar
			System.out.println("---------------------------");
			System.out.println("     Eliminar Jugador");
			System.out.println("---------------------------");
			String nombre = ingresarNombre();
			String apellido = ingresarApellido();
			
			Iterator<Jugador> iterator = jugadores.iterator();
	      	while(iterator.hasNext()) {
	      		Jugador jugador = iterator.next();
	      		if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
	      			System.out.println("Jugador encontrado:");
	      			jugador.mostrarTituloJugador();
	      			jugador.mostrarJugador();
	      			iterator.remove();
	      			System.out.println("Registro del jugador eliminado");
	      		}else {
	      			System.out.println("Jugador no encontrado");
	      		}
	      			
	      	}		

		}

	}

}
