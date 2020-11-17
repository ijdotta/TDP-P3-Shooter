package entidades;

import entidadesGraficas.EntidadGrafica;
import logica.Juego;
import movimientos.Movimiento;

public abstract class Personaje extends Entidad {

	// Atributos de instancia
	// Constructor
	/**
	 * 
	 * @param eg
	 * @param m
	 * @param v
	 */
	public Personaje(Juego j, EntidadGrafica eg, Movimiento m, int v) {
		super(j, eg, m, v);
	}
}
