package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.util.Listado;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		byte opcion = 0;

		while (opcion != 3) {
			System.out.println("------------------------");
			System.out.println("          MENU");
			System.out.println("------------------------");
			System.out.println("1 - Mostrar los productos");
			System.out.println("2 - Realizar una compra");
			System.out.println("3 - salir");
			System.out.print("Ingrese una opcion: ");
			;

			try {
				opcion = scanner.nextByte();
				scanner.nextLine();

				switch (opcion) {
				case 1:

					mostrarProductosDisponibles(Listado.getListadoProductos());

					break;
				case 2:
					realizarCompra(Listado.getListadoProductos());
					break;
				case 3:
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
		System.out.println("---------------------------------");
		System.out.println("       Lista de productos Disponibles:");
		System.out.println("---------------------------------");
		Listado.mostrarDetalle();

		for (Producto producto : productos) {
			if (producto.isDisponible())
				producto.mostrarDetalle();
		}
	}

	// realizar compra
	public static void realizarCompra(List<Producto> productos) {
		List<Producto> productosComprados = new ArrayList<Producto>();
	
		byte opcion = 0;

		while (opcion != 4) {
			System.out.println("------------------------");
			System.out.println("          MENU");
			System.out.println("------------------------");
			System.out.println("1 - Agregar productos");
			System.out.println("2 - Pagar en Efectivo");
			System.out.println("3 - Pagar con Tarjeta");
			System.out.println("4 - Volver");
			System.out.print("Ingrese una opcion: ");
			;

			try {
				opcion = scanner.nextByte();
				scanner.nextLine();

				switch (opcion) {
				case 1:
					agregarProductos(productos, productosComprados);

					break;
				case 2:
					pagarEnEfectivo(productosComprados);
					productosComprados=null;
					opcion = 4;
					break;
				case 3:
					pagarConTarjeta(productosComprados);
					productosComprados=null;
					opcion = 4;
					break;
				case 4:
					productosComprados=null;
					break;
				default:
					System.out.println("Error: Ingrese una opcion correcta: [1-4].");
				}
				
			} catch (InputMismatchException e) {
				//System.out.println("Error: Debe ingresar numeros enteros.");
				scanner.nextLine();
			} 
		}
	}
	public static void agregarProductos(List<Producto> productos, List<Producto> productosComprados) {
		
		String codigo = ingresarCodigo();
		
		Producto productoBuscado = buscarProducto(codigo, productos);
		if (productoBuscado!=null) {
			if(productoBuscado.isDisponible()) {
    			productosComprados.add(productoBuscado);
    			System.out.println("Producto agregado a la compra");
    			System.out.println(productosComprados);
    		}else {
    			System.out.println("Producto no disponible");
    		}
  		
    	}else {
    		System.out.println("Producto Inexistente");
    		}
    	}
		
	//PAgar en efectivo
	public static void pagarEnEfectivo(List<Producto> productosComprados) {
		if (productosComprados!=null) {
			System.out.println(productosComprados);
			PagoEfectivo pagoEfectivo = new PagoEfectivo();
			System.out.printf("%s \t%s \t%s\n", "Codigo Producto","Descripcion","Precio");
			Double montoParcial=0.;
			for (Producto producto: productosComprados) {
				System.out.printf("%10s\t\t%8s\t%5.2f\n",producto.getCodigo(),producto.getDescripcion(),
						producto.getPrecioUnitario());
				montoParcial = montoParcial + producto.getPrecioUnitario() ;
			}
			System.out.println("Monto Parcial: "+montoParcial);
			pagoEfectivo.setFechaPago(LocalDate.now());
			pagoEfectivo.setMontoPagado(montoParcial);
			
			pagoEfectivo.realizarPago(montoParcial);
			System.out.println("---------Resumen---------");
			System.out.println("---------------------------");
			pagoEfectivo.imprimirRecibo();
			System.out.println("---------------------------");
			
		}else {
			System.out.println("Ingrese productos");
		}
	}
	
	//PAgar en efectivo
		public static void pagarConTarjeta(List<Producto> productosComprados) {
			if (productosComprados!=null) {
				System.out.println(productosComprados);
				PagoTarjeta pagoTarjeta = new PagoTarjeta();
				System.out.printf("%s \t%s \t%s\n", "Codigo Producto","Descripcion","Precio");
				Double montoParcial=0.;
				for (Producto producto: productosComprados) {
					System.out.printf("%10s\t\t%8s\t%5.2f\n",producto.getCodigo(),producto.getDescripcion(),
							producto.getPrecioUnitario());
					montoParcial = montoParcial + producto.getPrecioUnitario() ;
				}
				System.out.println("Monto Parcial: "+montoParcial);
				
				String numeroTarjeta = ingresarNumeroTarjeta();
				
				pagoTarjeta.setNumTarjeta(numeroTarjeta);
				pagoTarjeta.setFechaPago(LocalDate.now());
				pagoTarjeta.setMontoPagado(montoParcial);
				
				
				pagoTarjeta.realizarPago(montoParcial);
				
				System.out.println("---------Resumen---------");
				System.out.println("---------------------------");
				pagoTarjeta.imprimirRecibo();
				System.out.println("---------------------------");
				
			}else {
				System.out.println("Ingrese productos");
			}
		}
	
	//Ingreso de codigo de producto
		static String ingresarCodigo() {
			String codigo="";
	        boolean correcto=false;
	        while (!correcto) {
	        	System.out.print("Ingrese el codigo de Producto: ");
	        	try {
			         codigo = scanner.nextLine();
			         if(codigo.isBlank()){
			        	 System.out.println("Error: Debe ingresar el codigo");
			         }else {
			        	 correcto=true;
			         }
	        	} catch (InputMismatchException e) {
	                System.out.println("Error: Debe ingresar un codigo correcto"); 
	                scanner.nextLine();
	            }   
	        }
			
			return codigo;
		}
		
		//Buscar Producto
				private static Producto buscarProducto(String codigo, List<Producto> productos) {
					Producto auxProducto = new Producto();
					auxProducto=null;
			        for (Producto producto : productos) {
			        	if (producto.getCodigo().equals(codigo)) {
			        		auxProducto= producto;
			            }                
			       }
			       return auxProducto;
			    }
				
	//Ingresar numero de tarjeta
	public static String ingresarNumeroTarjeta() {
		String numeroTarjeta="";
		
		
	    boolean correcto=false;
	    while (!correcto) {
	    	System.out.print("Ingrese el Numero de Tarjeta: ");
	     	try {
	     		numeroTarjeta = scanner.nextLine();
	     		
			    if(numeroTarjeta.isEmpty() || numeroTarjeta.length()<16){
			    	System.out.println("Error: Debe ingresar un numero de tarjeta correcto");
			    }else {
			    	correcto=true;
			    }
	        } catch (InputMismatchException e) {
	                System.out.println("Error: Debe ingresar el numero de tarjeta"); 
	        }     
	     }
		
		return numeroTarjeta;
	}

}
