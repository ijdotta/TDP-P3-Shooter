package logica.factories.proyectiles;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.proyectiles.Proyectil_Infectado;
import logica.factories.EntidadFactory;

/**
 * Class ProyectilInfectadoFactory Implementacion de una fabrica de proyectiles
 * infectados.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class ProyectilInfectadoFactory extends EntidadFactory {
	// Constructor
	/**
	 * Inicia la fabrica de proyectiles infectados
	 * 
	 * @param j juego a conocer
	 */
	public ProyectilInfectadoFactory(Juego j) {
		super(j);
	}

	@Override
	public Entidad crearEntidad() {
		return new Proyectil_Infectado(juego);
	}

}
