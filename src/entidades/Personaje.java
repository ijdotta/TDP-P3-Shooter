package entidades;

import entidadesGraficas.EntidadGrafica;
import factories.EntidadFactory;
import logica.Juego;
import movimientos.Movimiento;

public abstract class Personaje extends Entidad {

	// Atributos de instancia
	protected EntidadFactory proyectil;
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
	// Metodos
	public EntidadFactory getProyectil()
	{
		return proyectil;
	}
	
	public void setProyectil(EntidadFactory p)
	{
		proyectil = p;
	}
}
