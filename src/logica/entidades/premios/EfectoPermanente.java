package logica.entidades.premios;

import logica.Juego;
/**
 * Abstract Class EfectoPermanente Implementacion y definicion de los comportamientos
 * generales de un premio permanente.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public abstract class EfectoPermanente extends Premio {

	// Constructor
	/**
	 * Inicia el premio permanente
	 * @param j juego a conocer
	 */
	public EfectoPermanente(Juego j) {
		super(j);
	}

}
