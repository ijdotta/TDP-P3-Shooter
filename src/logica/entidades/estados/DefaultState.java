package logica.entidades.estados;

import logica.entidades.Entidad;

/**
 * Class DefaultState Implementacion unicamente para que la entidad sea capas de
 * moverse.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class DefaultState implements State {
	// Atributos de instancia
	protected Entidad entidad;

	// Constructor
	/**
	 * Inicia el state conociendo a su entidad.
	 * 
	 * @param e entidad a conocer
	 */
	public DefaultState(Entidad e) {
		this.entidad = e;
	}

	// Metodos
	/**
	 * la entidad no tiene comportamiento al disparar, es decir, no dispara
	 */
	public void disparar() {
	}

	/**
	 * la entidad no tiene comportamiento al morir
	 */
	public void morir() {
	}

	/**
	 * Hace que la entidad actual se mueva segun su movimiento
	 */
	public void mover() {
		entidad.getMovimiento().mover();
	}

}
