package logica.factories.premios;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.premios.EfectoSuperArma;
import logica.factories.EntidadFactory;

/**
 * Class PremioTemporalSuperArmaFactory Implementacion de una fabrica de premios
 * super arma.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class PremioTemporalSuperArmaFactory extends EntidadFactory {
	// Constructor
	/**
	 * Inicia la fabrica de premios super arma
	 * 
	 * @param j juego a conocer
	 */
	public PremioTemporalSuperArmaFactory(Juego j) {
		super(j);
	}

	@Override
	public Entidad crearEntidad() {
		return new EfectoSuperArma(juego);
	}

}
