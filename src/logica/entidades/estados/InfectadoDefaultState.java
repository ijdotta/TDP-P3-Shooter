package logica.entidades.estados;

import java.util.Random;

import logica.entidades.infectados.Infectado;
/**
 * Class InfectadoDefaultState Implementacion del comportamiento general de un infectado.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class InfectadoDefaultState implements State {

	// Atributos de instancia
	protected Infectado infectado;
	
	// Constructor
	/**
	 * Inicia el state conociendo a su infectado.
	 * @param infectado infectado a conocer
	 */
	public InfectadoDefaultState(Infectado infectado) {
		this.infectado = infectado;
	}

	// Metodos
	/**
	 * el infectado le pide al juego que genere un disparo.
	 */
	public void disparar() {
		infectado.getJuego().generarDisparo(infectado);
	}

	/**
	 * el infectado le pide al juego que genere un premio con un 33% de chance de que ocurra esto.
	 */
	public void morir() {
		Random r = new Random();
		//P(soltarPremio) = 1/3
		if (r.nextInt(3) == 0) {
			infectado.getJuego().generarPremio(infectado);
		}
		infectado.getJuego().decrementarInfectados();
	}

	/**
	 * el infectado se mueve segun su movimiento actual
	 */
	public void mover() {
		infectado.getMovimiento().mover();
	}

}
