package logica.entidades.proyectiles;

import logica.Juego;
import logica.entidades.Entidad;

/**
 * Abstract Class Proyectil Implementacion y definicion de los comportamientos
 * generales de un proyectil.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public abstract class Proyectil extends Entidad {

	// Constructor
	/**
	 * Inicia el proyectil actual
	 * 
	 * @param j juego a conocer
	 */
	public Proyectil(Juego j) {
		super(j);
	}
}