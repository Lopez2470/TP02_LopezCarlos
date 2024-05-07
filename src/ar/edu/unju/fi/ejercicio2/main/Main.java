package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;
import ar.edu.unju.fi.ejercicio2.util.Listado;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Mes mes;
		byte opcion = 0;

		while (opcion != 5) {
			System.out.println("------------------------");
			System.out.println("          MENU");
			System.out.println("------------------------");
			System.out.println("1- Crear efeméride");
			System.out.println("2- Mostrar efemérides");
			System.out.println("3- Eliminar efeméride");
			System.out.println("4- Modificar efeméride");
			System.out.println("5- Salir");
			System.out.print("Ingrese una opción: ");

			try {
				opcion = scanner.nextByte();
				scanner.nextLine();

				switch (opcion) {
				case 1:
					if (crearEfemeride(Listado.listadoEfemerides)) {
						System.out.println("--------------------------------------");
						System.out.println("Efemeride creada correctamente.");
						System.out.println("Efemerides dadass de alta: " + Listado.listadoEfemerides.size());
						System.out.println("--------------------------------------");
					} else {
						System.out.println("Error al dar de alta un Producto");
					}
					break;
				case 2:
					mostrarEfemerides(Listado.listadoEfemerides);
					break;
				case 3:
					eliminarEfemeride(Listado.listadoEfemerides);
					break;
				case 4:
					modificarEfemeride(Listado.listadoEfemerides);
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

	// Crear Efemeride
	static Boolean crearEfemeride(List<Efemeride> efemerides) {
		String codigo = ingresarCodigo();
		int mesE = ingresarMes();
		// Asignar mes
		Mes mes;
		mes = Mes.values()[mesE - 1];
		int dia = ingresarDia(mes);
		String detalle = ingresarDetalle();
		Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
		return efemerides.add(efemeride);
	}

	// Ingreso de codigo de efemeride
	static String ingresarCodigo() {
		String codigoE = "";
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Ingrese el codigo: ");
			try {
				codigoE = scanner.nextLine();
				if (codigoE.isBlank()) {
					System.out.println("Error: Debe ingresar el codigo");
				} else {
					correcto = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar un codigo correcto");
				scanner.nextLine();
			} finally {

			}
		}

		return codigoE;
	}

	// Ingreso de Mes
	static int ingresarMes() {
		int mesE = 0;
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Ingrese el mes de la efemeride: ");
			try {
				mesE = scanner.nextInt();
				if (mesE < 1 || mesE > 12) {
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
		return mesE;
	}

	// Ingreso del dia
	static int ingresarDia(Mes mes) {
		int diaE = 0;
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Ingrese el dia del mes " + mes.name().toLowerCase() + ": ");
			// No se realiza la verificacion exacta de los dias de los meses validos
			try {
				diaE = scanner.nextInt();
				if (diaE < 1 || diaE > 31) {
					System.out.println("Error: Debe ingresar un dia valido");
				} else {
					correcto = true;
					scanner.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar el valor de un número");
				scanner.nextLine();
			}
		}
		return diaE;
	}

	// Ingreso de descripcion de producto
	static String ingresarDetalle() {
		String detalle = "";
		boolean correcto = false;
		while (!correcto) {
			System.out.print("Ingrese el detalle de la efemeride: ");
			try {
				detalle = scanner.nextLine();
				if (detalle.isBlank()) {
					System.out.println("Error: Debe ingresar el detalle");
				} else {
					correcto = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar un detalle");
			}
		}
		return detalle;
	}

	// Mostrar Efemerides
	private static void mostrarEfemerides(List<Efemeride> efemerides) {
		if (efemerides.isEmpty()) {
			System.out.println("No hay efemerides cargadas.");
		} else {
			System.out.println("---------------------------------");
			System.out.println("       Lista de Efemerides:");
			System.out.println("---------------------------------");

			for (Efemeride efemeride : efemerides) {
				System.out.println(efemeride);
			}
		}

		// efemerides.forEach(e->System.out.println(e));
	}

	// Modificar efemeride
	static void eliminarEfemeride(List<Efemeride> efemerides) {
		if (efemerides.isEmpty()) {
			System.out.println("No hay efemerides cargadas.");
		} else {
			// Ingresar el efemeride a modificar
			System.out.println("---------------------------");
			System.out.println("Eliminar Efemeride");
			System.out.println("---------------------------");
			String codigoE = ingresarCodigo();
			// Buscar efemeride
			Efemeride efemerideBuscado = buscarEfemeride(codigoE, efemerides);
			if (efemerideBuscado != null) {
				System.out.println("Efemeride encontrada:");
				System.out.println(efemerideBuscado);
				efemerides.remove(efemerideBuscado);
				System.out.println("Efemeride Eliminada.");
			} else {
				System.out.println("Efemeride no encontrada.");
			}

		}
			
	}

	// Modificar Efemeride
	static void modificarEfemeride(List<Efemeride> efemerides) {
		if (efemerides.isEmpty()) {
			System.out.println("No hay efemerides cargadas.");
		} else {
			// Ingresar el efemeride a modificar
			System.out.println("---------------------------");
			System.out.println("Modificar Efemeride");
			System.out.println("---------------------------");
			String codigoE = ingresarCodigo();
			// Buscar efemeride
			Efemeride efemerideBuscado = buscarEfemeride(codigoE, efemerides);
			if (efemerideBuscado != null) {
				System.out.println("Efemeride encontrada:");
				System.out.println(efemerideBuscado);
				Byte opcion = 0;
				while (opcion != 4) {
					System.out.println("---------------------------------");
					System.out.println("-------- Modificaciones ---------");
					System.out.println("---------------------------------");
					System.out.println("1- Mes");
					System.out.println("2- Dia");
					System.out.println("3- Detalle");
					System.out.println("4- Salir de modificaciones");
					try {
						opcion = scanner.nextByte();
						scanner.nextLine();

						switch (opcion) {
						case 1:

							int mesE = ingresarMes();
							Mes mes;
							mes = Mes.values()[mesE - 1];
							efemerideBuscado.setMes(mes);
							System.out.println("Efemeride Modificada");
							break;
						case 2:
							efemerideBuscado.setDia(ingresarDia(efemerideBuscado.getMes()));
							System.out.println("Efemeride Modificada");
							break;
						case 3:
							efemerideBuscado.setDetalle(ingresarDetalle());
							System.out.println("Efemeride Modificada");
							break;
						case 4:
							break;
						default:
							System.out.println("Error: Ingrese una opcion correcta: [1-4].");
						}
					} catch (InputMismatchException e) {
						System.out.println("Error: Debe ingresar numeros enteros.");
						scanner.nextLine();
					}
				}
			} else {
				System.out.println("Efemerideno encontrado.");
			}

		}

	}

	// Buscar Efemeride
	private static Efemeride buscarEfemeride(String codigo, List<Efemeride> efemerides) {
		Efemeride auxEfemeride = new Efemeride();
		auxEfemeride = null;
		for (Efemeride efemeride : efemerides) {
			if (efemeride.getCodigo().equals(codigo)) {
				auxEfemeride = efemeride;
			}
		}
		return auxEfemeride;
	}

}
