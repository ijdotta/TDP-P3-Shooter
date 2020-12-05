package logica.entidades.premios;

import logica.Juego;
import logica.entidades.Entidad;
import logica.movimientos.MVertical;
/**
 * Abstract Class Premio Implementacion y definicion de los comportamientos
 * generales de un premio.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public abstract class Premio extends Entidad {

	/**
	 * Inicia el premio con un movimiento vertical hacia abajo.
	 * @param j juego a conocer
	 */
	public Premio(Juego j) {
		super(j);
		movimiento = new MVertical(this, MVertical.DOWN);
	}

}
