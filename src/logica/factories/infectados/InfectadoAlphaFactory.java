package logica.factories.infectados;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.infectados.Alpha;
import logica.factories.EntidadFactory;

/**
 * Class InfectadoAlphaFactory Implementacion de una fabrica de infectados tipo
 * alpha.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class InfectadoAlphaFactory extends EntidadFactory {
	// Constructor
	/**
	 * Inicia la fabrica de infectados tipo alpha
	 * 
	 * @param j juego a conocer
	 */
	public InfectadoAlphaFactory(Juego j) {
		super(j);
	}

	@Override
	public Entidad crearEntidad() {
		return new Alpha(juego);
	}

}
