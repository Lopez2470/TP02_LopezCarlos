package ar.edu.unju.fi.ejercicio0001.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio0001.model.Producto;
import ar.edu.unju.fi.ejercicio0001.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio0001.model.Producto.OrigenFabricacion;





public class Main {
	static Scanner scanner= new Scanner(System.in);
	//List<Producto> productos = new ArrayList<Producto>();
	public static void main(String[] args) {
		List<Producto> productos = new ArrayList<Producto>();
        byte opcion = 0;
        while (opcion !=4) {
        	System.out.println("------------------------");
            System.out.println("          MENU");
            System.out.println("------------------------");
    		System.out.println("1-Crear producto");
    		System.out.println("2-Mostrar productos");
    		System.out.println("3-Modificar producto");
    		System.out.println("4-Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextByte();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                    	if (crearProducto(productos)) {
                        	System.out.println("--------------------------------------");
                        	System.out.println("Producto dado de alta correctamente.");
                        	System.out.println("Productos dados de alta: " + productos.size());
                        	System.out.println("--------------------------------------");
                        }else {
                        	System.out.println("Error al dar de alta un Producto");
                        }
                        break;
                    case 2:
                       mostrarProductos(productos);
                        break;
                    case 3:
                       modificarProducto(productos);
                        break;
                    case 4:
                        System.out.println("Salida del Menu");
                        break;
                    default:
                        System.out.println("Error: Ingrese una opcion correcta: [1-4].");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar numeros enteros.");
                scanner.nextLine(); 
            }   finally {
                
            }
        }
        scanner.close();
	}
	
	//Crear Producto
	static Boolean crearProducto(List<Producto> productos) {
		String codigoP = ingresarCodigo();
		String descripcionP=ingresarDescripcion();
		Double precioP=ingresarPrecio();
		String origen = ingresarOrigenFabricacion();
		String categoria = ingresarCategoria();
		Producto producto = new Producto(codigoP, descripcionP,precioP, OrigenFabricacion.valueOf(origen),
				Categoria.valueOf(categoria));
		return productos.add(producto);
	
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
            }   finally {
            	
            }  
        }
		
		return codigo;
	}
	//Ingreso de descripcion de producto
	static String ingresarDescripcion() {
		String descripcion="";
        boolean correcto=false;
        while (!correcto) {
        	System.out.print("Ingrese la descripcion del Producto: ");
        	try {
        		descripcion = scanner.nextLine();
		         if(descripcion.isBlank()){
		        	 System.out.println("Error: Debe ingresar la descripcion");
		         }else {
		        	 correcto=true;
		         }
        	} catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar una descripcion"); 
            }     
        }
		
		return descripcion;
	}
	
	//Ingreso de Precio de producto
	static Double ingresarPrecio() {
		Double precioP=0.;
	    boolean correcto=false;
	    while (!correcto) {
	    	System.out.print("Ingrese el precio de Producto: ");
	     	try {
	     		precioP = scanner.nextDouble();
			    if(precioP <= 0){
			    	System.out.println("Error: Debe ingresar el precio");
			    }else {
			    	correcto=true;
			    }
	        } catch (InputMismatchException e) {
	                System.out.println("Error: Debe ingresar el valor de un precio"); 
	                scanner.nextLine();
	        }     
	     }
		 return precioP;
	}
	
	//Ingreso de Origen de Fabricacion
	static String ingresarOrigenFabricacion() {
		String origen ="";
		Byte opcion=0;
		while (opcion <= 0 || opcion > 4) {
        	System.out.println("---------------------------------");
            System.out.println("---- Origen de fabricación ------");
            System.out.println("---------------------------------");
    		System.out.println("1- Argentina");
    		System.out.println("2- China");
    		System.out.println("3- Brasil");
    		System.out.println("4- Uruguay");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextByte();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        origen = "ARGENTINA";
                        break;
                    case 2:
                    	origen = "CHINA";
                        break;
                    case 3:
                    	origen = "BRASIL";
                        break;
                    case 4:
                    	origen = "URUGUAY";
                        break;
                    default:
                        System.out.println("Error: Ingrese una opcion correcta: [1-4].");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar numeros enteros.");
                scanner.nextLine(); 
            } 
        }
		System.out.println("Origen de Fabricacion elegido: "+origen);
		return origen;
	}
	
	//Ingreso de Categoria
	static String ingresarCategoria() {
		String categoria ="";
		Byte opcion=0;
		while (opcion <= 0 || opcion > 4) {
        	System.out.println("---------------------------------");
            System.out.println("---------- Categoría ------------");
            System.out.println("---------------------------------");
    		System.out.println("1- Telefonía");
    		System.out.println("2- Informática");
    		System.out.println("3- Electro hogar");
    		System.out.println("4- Herramientas");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextByte();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        categoria = "TELEFONIA";
                        break;
                    case 2:
                    	categoria = "INFORMATICA";
                        break;
                    case 3:
                    	categoria = "ELECTROHOGAR";
                        break;
                    case 4:
                    	categoria = "HERRAMIENTAS";
                        break;
                    default:
                        System.out.println("Error: Ingrese una opcion correcta: [1-4].");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar numeros enteros.");
                scanner.nextLine(); 
            } 
        }
		System.out.println("Categoria elegida es: "+categoria);
		return categoria;
	}
	
	//Mostrar productos
	private static void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }
        System.out.println("---------------------------------");
        System.out.println("       Lista de productos:");
        System.out.println("---------------------------------");
        
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
	
	//Modificar Producto
	static void modificarProducto(List<Producto> productos) {
		if (productos.isEmpty()) {
			System.out.println("No hay productos cargados."); 
	    }else {
	    	//Ingresar el prodcuto a modificar
	    	System.out.println("---------------------------");
	       	System.out.println(     "Modificar Producto");
	       	System.out.println("---------------------------");
	       	String codigoP = ingresarCodigo();
	       	//Buscar el producto
	       	Producto productoBuscado = buscarProducto(codigoP, productos);
        	if (productoBuscado != null) {
        		System.out.println("Producto encontrado:");
        		System.out.println(productoBuscado);
        		Byte opcion=0;
        		while (opcion !=5) {
                	System.out.println("---------------------------------");
                    System.out.println("-------- Modificaciones ---------");
                    System.out.println("---------------------------------");
            		System.out.println("1- Descripcion");
            		System.out.println("2- Precio");
            		System.out.println("3- Origen de Fabricacion");
            		System.out.println("4- Categoria");
            		System.out.println("5- Salir de modificaciones");
            		
                    System.out.print("Ingrese una opción: ");

                    try {
                        opcion = scanner.nextByte();
                        scanner.nextLine(); 

                        switch (opcion) {
                            case 1:
                            	String descripcionP=ingresarDescripcion();
                            	productoBuscado.setDescripcion(descripcionP);
                            	System.out.println("Producto Modificado");
                            	
                                break;
                            case 2:
                            	Double precioP=ingresarPrecio();
                            	productoBuscado.setPrecioUnitario(precioP);
                            	System.out.println("Producto Modificado");
                                break;
                            case 3:
                            	String origen = ingresarOrigenFabricacion();
                            	productoBuscado.setOrigenFabricacion(OrigenFabricacion.valueOf(origen));
                            	System.out.println("Producto Modificado");
                                break;
                            case 4:
                            	String categoria = ingresarCategoria();
                            	productoBuscado.setCategoria(Categoria.valueOf(categoria));
                            	System.out.println("Producto Modificado");
                                break;
                            default:
                                System.out.println("Error: Ingrese una opcion correcta: [1-4].");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Debe ingresar numeros enteros.");
                        scanner.nextLine(); 
                    } 
                }  		
        	}else {
        		System.out.println("Producto no encontrado.");
            }

	    }
					
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
}