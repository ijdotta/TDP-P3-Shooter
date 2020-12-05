package logica.entidades.premios;

import logica.Juego;
/**
 * Abstract Class EfectoTemporal Implementacion y definicion de los comportamientos
 * generales de un premio temporal.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public abstract class EfectoTemporal extends Premio {

	// Constructor
	/**
	 * Inicia el premio temporal
	 * @param j juego a conocer
	 */
	public EfectoTemporal(Juego j) {
		super(j);
	}

}
