package logica.factories.infectados;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.infectados.Beta;
import logica.factories.EntidadFactory;

/**
 * Class InfectadoBetaFactory Implementacion de una fabrica de infectados tipo
 * beta.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class InfectadoBetaFactory extends EntidadFactory {
	// Constructor
	/**
	 * Inicia la fabrica de infectados tipo beta
	 * 
	 * @param j juego a conocer
	 */
	public InfectadoBetaFactory(Juego j) {
		super(j);
	}

	@Override
	public Entidad crearEntidad() {
		return new Beta(juego);
	}

}
