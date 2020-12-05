package logica.entidades.premios.timers;

import javax.swing.Timer;

import logica.Juego;
/**
 * Abstract Class TimerP Implementacion general del timer de un premio.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public abstract class TimerP {

	// Atributos
	protected Timer timer;
	protected Juego juego;

	// Metodos
	/**
	 * Inicia el timer del premio actual
	 */
	public void start() {
		timer.start();
	}
	/**
	 * Frena el timer del premio actual
	 */
	public void stop() {
		timer.stop();
	}
	/**
	 * Reinicia el timer del premio actual
	 */
	public void restart() {
		timer.restart();
	}
	/**
	 * Indica si el timer esta corriendo
	 * @return True si esta corriendo, false caso contrario
	 */
	public boolean isRunning() {
		return timer.isRunning();
	}

	// Setters / Getters
	/**
	 * Settea el juego actual con el que es pasado por parametro.
	 * 
	 * @param j juego nuevo
	 */
	public void setJuego(Juego j) {
		juego = j;
	}
}
