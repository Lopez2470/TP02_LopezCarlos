package ar.edu.unju.fi.ejercicio7.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio7.model.Producto;
import ar.edu.unju.fi.ejercicio7.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio7.model.Producto.OrigenFabricacion;



public class Listado {
	public static List<Producto> listadoProductos= new ArrayList<Producto>();
		
	

	public Listado() {
	}

	public static List<Producto> getListadoProductos() {
		listadoProductos.add(new Producto("T001","Cargador",8500.,OrigenFabricacion.ARGENTINA,Categoria.TELEFONIA,false));
		listadoProductos.add(new Producto("T002", "Cable USB",3000.,OrigenFabricacion.CHINA,Categoria.TELEFONIA,false));
		listadoProductos.add(new Producto("T003","Auriculares",6000.,OrigenFabricacion.CHINA,Categoria.TELEFONIA,true));
		listadoProductos.add(new Producto("T004","Cargador",7500.,OrigenFabricacion.BRASIL,Categoria.TELEFONIA,true));
		listadoProductos.add(new Producto("I010","Mouse",15000.,OrigenFabricacion.URUGUAY,Categoria.INFORMATICA,true));
		listadoProductos.add(new Producto("I020","Parlantes",8000.,OrigenFabricacion.ARGENTINA,Categoria.INFORMATICA,false));
		listadoProductos.add(new Producto("I011","Teclado",75000.,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,true));
		listadoProductos.add(new Producto("I030","Pendrive",18500.,OrigenFabricacion.CHINA,Categoria.INFORMATICA,false));
		listadoProductos.add(new Producto("E001","Calefactor",200000.,OrigenFabricacion.ARGENTINA,Categoria.ELECTROHOGAR,false));
		listadoProductos.add(new Producto("E002","Microondas",400000.,OrigenFabricacion.BRASIL,Categoria.ELECTROHOGAR,true));
		listadoProductos.add(new Producto("E003","Heladera",850000.,OrigenFabricacion.CHINA,Categoria.ELECTROHOGAR,true));
		listadoProductos.add(new Producto("E004","Cafetera",390000.,OrigenFabricacion.CHINA,Categoria.ELECTROHOGAR,true));
		listadoProductos.add(new Producto("H001","Taladro",250000.,OrigenFabricacion.BRASIL,Categoria.ELECTROHOGAR,true));
		listadoProductos.add(new Producto("H002","Compresor de aire",125000.,OrigenFabricacion.ARGENTINA,Categoria.ELECTROHOGAR,false));
		listadoProductos.add(new Producto("H003","Hidrolavadora",110000.,OrigenFabricacion.URUGUAY,Categoria.ELECTROHOGAR,true));
		return listadoProductos;
	}

	public static void setListadoProductos(List<Producto> listadoProductos) {
		Listado.listadoProductos = listadoProductos;
	}

	public static void mostrarDetalle() {
		System.out.printf("%s \t%s \t%s \t\t%s \t%s\n", "Codigo Producto","Descripcion","Precio", "Origen","Categoria");
	}
		

}
