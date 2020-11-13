package niveles;

import entidades.Entidad;
import factories.EntidadFactory;

public class NivelZero extends Nivel {
	
	public NivelZero() {
		/*Idea: */
		fInfectados[0] = new InfectadoSuperAlfaFactory();
		
		/*Cuando se ejecute el método configurar en la clase NivelZero, la fábrica Alfa estará redefinida y creará otra 
		 * ahora SuperAlfa */ 
	}

}

/**
 * Esto lo creo aca para que compile el código, pero es solo un ejemplo de la dinámica
 * que propongo con el constructor de cada Nivel
 * 
 * La factory real iría en el package Factories, pero no quería ensuciarlo ahora.
 * @author Ignacio
 *
 */
class InfectadoSuperAlfaFactory extends EntidadFactory {

	@Override
	public Entidad crearEntidad() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
