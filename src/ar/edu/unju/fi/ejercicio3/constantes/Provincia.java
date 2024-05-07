package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(811611,53219), 
	SALTA(1441351,155488), 
	TUCUMAN(1731820,22524), 
	CATAMARCA(429562,102602),
	LA_RIOJA( 383865,89680),
	SANTIAGO_DEL_ESTERO(1060906,136351);

	private Integer poblacion;
	private Integer superficie;
	
	
	private Provincia() {
	}
	
	
	private Provincia(Integer poblacion, Integer superficie) {
		this.poblacion = poblacion;
		this.superficie = superficie;
	}


	public Integer getPoblacion() {
		return poblacion;
	}


	public Integer getSuperficie() {
		return superficie;
	}
	
	public Float calcularDensidad() {
		return (float) this.poblacion/this.superficie;
	}

	
	
	

	
	

}
