package logica.entidades.estados;

import logica.entidades.infectados.Infectado;
/**
 * Class InfectadoCongeladoState Implementacion del comportamiento de un infectado que esté congelado.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class InfectadoCongeladoState extends InfectadoDefaultState {

	// Constructor
	/**
	 * Inicia el state conociendo a su infectado.
	 * @param infectado infectado a conocer
	 */
	public InfectadoCongeladoState(Infectado infectado) {
		super(infectado);
	}

	// Metodos
	/**
	 * no puede disparar
	 */
	public void disparar() {
		// no hacer nada
	}

	/**
	 * no puede moverse
	 */
	@Override
	public void mover() {
		// no hacer nada
	}

}
