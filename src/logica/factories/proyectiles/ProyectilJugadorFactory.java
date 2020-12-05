package logica.factories.proyectiles;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.proyectiles.Proyectil_Jugador;
import logica.factories.EntidadFactory;

/**
 * Class ProyectilJugadorFactory Implementacion de una fabrica de proyectiles de
 * jugador.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class ProyectilJugadorFactory extends EntidadFactory {
	// Constructor
	/**
	 * Inicia la fabrica de proyectiles de jugador
	 * 
	 * @param j juego a conocer
	 */
	public ProyectilJugadorFactory(Juego j) {
		super(j);
	}

	@Override
	public Entidad crearEntidad() {
		return new Proyectil_Jugador(juego);
	}

}
