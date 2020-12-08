package logica.entidades.premios;

import logica.Juego;
import logica.entidades.premios.timers.TimerP;
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

	// Atributos de instancia
	protected TimerP timer;
	// Constructor
	/**
	 * Inicia el premio temporal
	 * @param j juego a conocer
	 */
	public EfectoTemporal(Juego j) {
		super(j);
	}
	/**
	 * Retorna el timer del premio actual
	 * @return timer del premio actual
	 */
	public TimerP getTimer() {
		return timer;
	}
}
