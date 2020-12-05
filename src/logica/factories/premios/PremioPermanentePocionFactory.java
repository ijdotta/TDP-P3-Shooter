package logica.factories.premios;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.premios.EfectoPocion;
import logica.factories.EntidadFactory;

/**
 * Class PremioPermanentePocionFactory Implementacion de una fabrica de premios
 * pocion.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class PremioPermanentePocionFactory extends EntidadFactory {
	// Constructor
	/**
	 * Inicia la fabrica de premios pocion
	 * 
	 * @param j juego a conocer
	 */
	public PremioPermanentePocionFactory(Juego j) {
		super(j);
	}

	@Override
	public Entidad crearEntidad() {
		return new EfectoPocion(juego);
	}

}
