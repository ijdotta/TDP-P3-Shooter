package logica.factories.proyectiles;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.proyectiles.Proyectil_Fuerte;
import logica.factories.EntidadFactory;

/**
 * Class ProyectilFuerteFactory Implementacion de una fabrica de proyectiles
 * fuertes.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class ProyectilFuerteFactory extends EntidadFactory {
	// Constructor
	/**
	 * Inicia la fabrica de proyectiles fuertes
	 * 
	 * @param j juego a conocer
	 */
	public ProyectilFuerteFactory(Juego j) {
		super(j);
	}

	@Override
	public Entidad crearEntidad() {
		return new Proyectil_Fuerte(juego);
	}

}
