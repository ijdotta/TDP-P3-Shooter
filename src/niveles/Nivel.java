package niveles;

import java.util.List;

import entidades.Entidad;
import factories.EntidadFactory;
import factories.InfectadoAlphaFactory;
import factories.InfectadoBetaFactory;
import factories.PremioPermanentePocionFactory;
import logica.Juego;

public abstract class Nivel {
	
	protected Juego juego;
	protected Nivel siguienteNivel;

	protected int cantidad_infectados;
	protected EntidadFactory [] fInfectados; //Capaz usar un arreglo en lugar de lo anterior.
	protected EntidadFactory [] fPremios;
	
	/**
	 * Si hacemos esto as�, de alguna forma los niveles pueden reutilizar el m�todo configurar,
	 * pero pueden ir variando las f�bricas (y as�, el tipo espec�fico de infectado) desde su propio constructor.
	 * Probablemente habrpia que a�adir m�s varables fInfectados
	 */
	public Nivel() {
		cantidad_infectados = 20;
		fInfectados = new EntidadFactory[3];
		fInfectados[0] = new InfectadoAlphaFactory();
		fInfectados[1] = new InfectadoBetaFactory();
		
		fPremios = new EntidadFactory[3];
		fPremios[0] = new PremioPermanentePocionFactory();
	}
	
	/**
	 * Crea la nueva lista de entidades del juego (o vac�a la lista vieja y carga las nuevas entidades en 
	 * la misma lista [ver como afecta esto a la GUI])
	 */
	public void configurar() {
		// TODO Auto-generated method stub
		List<Entidad> entidades = juego.getEntidades();
		
		for(Entidad e : entidades) {
			//eliminar rastro gr�fico, etc.
			entidades.remove(e);
		}
		
		for (int i = 0; i < cantidad_infectados / 2; i ++) {
			entidades.add(fInfectados[0].crearEntidad());
		}
		
	}
	
	/**
	 * �Se encarga de limpiar el juego y hacer que se limpie la GUI de cosas viejas del nivel anterior, para configurar el nuevo nivel?
	 */
	public void limpiar() {
		
	}

	public void siguienteNivel() {
		if (siguienteNivel != null) {
			juego.setNivel(siguienteNivel);
			juego.getNivel().configurar();
		}
		else {
			juego.finalizarJuego();
		}
	}
}
