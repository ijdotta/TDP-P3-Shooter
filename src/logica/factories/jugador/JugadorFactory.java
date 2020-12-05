package logica.factories.jugador;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.jugador.Jugador;
import logica.factories.EntidadFactory;

/**
 * Class JugadorFactory Implementacion de una fabrica de jugadores.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class JugadorFactory extends EntidadFactory {
	// Constructor
	/**
	 * Inicia la fabrica de jugadores
	 * 
	 * @param j juego a conocer
	 */
	public JugadorFactory(Juego j) {
		super(j);
	}

	@Override
	public Entidad crearEntidad() {
		return new Jugador(juego);
	}

}
