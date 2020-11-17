package entidades;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Personaje extends Entidad{	

	// Atributos de instancia
	// Constructor
	/**
	 * 
	 * @param eg
	 * @param m
	 * @param v
	 */
	public Personaje(EntidadGrafica eg, Movimiento m, int v) {
		super(eg, m, v);
	}	
}
