package logica.factories;

import logica.Juego;
import logica.entidades.Entidad;

/**
 * Abstract Class EntidadFactory Implementacion y definicion del comportamiento
 * de una factory de entidades en general.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public abstract class EntidadFactory {
	// Atributos de instancia
	protected Juego juego;

	// Constructor
	/**
	 * Inicia la factory con su juego a conocer
	 * 
	 * @param j juego a conocer
	 */
	public EntidadFactory(Juego j) {
		juego = j;
	}

	// Metodos
	/**
	 * Retorna un objeto concreto, indicado por el nombre de la clase.
	 * 
	 * @return objeto concreto
	 */
	public abstract Entidad crearEntidad();

	/**
	 * Retorna el juego actual
	 * 
	 * @return juego actual
	 */
	public Juego getJuego() {
		return juego;
	}

	/**
	 * Settea el juego actual con el que es pasado por parametro.
	 * 
	 * @param j juego nuevo
	 */
	public void setJuego(Juego j) {
		juego = j;
	}
}
