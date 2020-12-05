package logica.entidades;

import logica.Juego;
import logica.factories.EntidadFactory;

/**
 * Abstract Class Personaje Implementacion y definicion de los comportamientos
 * generales de un personaje.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public abstract class Personaje extends Entidad {

	// Atributos de instancia
	protected EntidadFactory proyectil;

	// Constructor
	/**
	 * Inicia el personaje con 10 de daño
	 * 
	 * @param j juego actual
	 */
	public Personaje(Juego j) {
		super(j);
	}

	// Metodos
	/**
	 * Retorna la factory de proyectiles actual
	 * 
	 * @return factory de proyectiles actual
	 */
	public EntidadFactory getProyectil() {
		return proyectil;
	}

	/**
	 * Settea la factory de proyectiles actual con la que es pasada por parametro.
	 * 
	 * @param p factory de proyectiles nueva
	 */
	public void setProyectil(EntidadFactory p) {
		proyectil = p;
	}
}
