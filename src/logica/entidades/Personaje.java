package logica.entidades;

import logica.Juego;
import logica.factories.EntidadFactory;

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
	public Personaje(Juego j) {
		super(j);
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
