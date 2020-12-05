package logica.factories.premios;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.premios.EfectoCuarentena;
import logica.factories.EntidadFactory;

/**
 * Class PremioTemporalCuarentenaFactory Implementacion de una fabrica de
 * premios cuarentena.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class PremioTemporalCuarentenaFactory extends EntidadFactory {
	// Constructor
	/**
	 * Inicia la fabrica de premios cuarentena
	 * 
	 * @param j juego a conocer
	 */
	public PremioTemporalCuarentenaFactory(Juego j) {
		super(j);
	}

	@Override
	public Entidad crearEntidad() {
		return new EfectoCuarentena(juego);
	}

}
