package niveles;

import entidades.Entidad;
import factories.EntidadFactory;
import logica.Juego;

public class NivelZero extends Nivel {
	
	public NivelZero(Juego j) {
		super(j);
		/*Idea: */
		fInfectados[0] = new InfectadoSuperAlfaFactory(juego);
		
		/*Cuando se ejecute el m�todo configurar en la clase NivelZero, la f�brica Alfa estar� redefinida y crear� otra 
		 * ahora SuperAlfa */ 
	}

}

/**
 * Esto lo creo aca para que compile el c�digo, pero es solo un ejemplo de la din�mica
 * que propongo con el constructor de cada Nivel
 * 
 * La factory real ir�a en el package Factories, pero no quer�a ensuciarlo ahora.
 * @author Ignacio
 *
 */
class InfectadoSuperAlfaFactory extends EntidadFactory {

	public InfectadoSuperAlfaFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
