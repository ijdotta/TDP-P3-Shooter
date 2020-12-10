package logica.niveles;

import java.util.Random;

import logica.Juego;
import logica.entidades.Entidad;
import logica.factories.EntidadFactory;

/**
 * Abstract Class Nivel Implementacion y definicion de un nivel en general.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public abstract class Nivel {

	// Atributos de instancia
	protected Juego juego;
	protected Nivel siguienteNivel;

	protected int cantidad_infectados; // Cantidad que falta por aparecer.
	protected int cant_primeraTanda; // Cantidad de infectados de la primera tanda.
	protected EntidadFactory[] fInfectados;
	protected EntidadFactory[] fPremios;

	// Constructor
	/**
	 * Inicia el nivel con su juego a conocer
	 * 
	 * @param j juego a conocer
	 */
	public Nivel(Juego j) {
		juego = j;
	}

	// Metodos
	/**
	 * Cada nivel va a determinar su background, el nivel en el que está, los tipos
	 * de infectados que se van a generar y su cantidad, los tipos de premios que se
	 * pueden generar (junto a su timer si es un premio temporal). Ademas debe
	 * setear su siguiente nivel, si no tiene entonces null.
	 */
	public abstract void configurar();
	/**
	 * Indica los tipos y cantidad de infectados que se generan en la primer tanda.
	 */
	public abstract void primeraTanda();

	/**
	 * Indica los tipos y cantidad de infectados que se generan en la segunda tanda.
	 */
	public abstract void segundaTanda();

	/**
	 * Si el nivel se ganó, pasar al siguiente nivel pidiendole al juego que limpie
	 * cualquier residuo y reposicione al jugador. Si no hay mas niveles es porque
	 * se gano el juego.
	 */
	public void siguienteNivel() {
		if (siguienteNivel != null) {
			juego.limpiarTodoMenosJugador();
			juego.posicionInicialJugador();

			juego.setNivel(siguienteNivel);
			juego.getNivel().configurar();
		} else {
			juego.finalizarJuego();
		}
	}

	/**
	 * Indica si hay premios
	 * 
	 * @return true si hay premios, false caso contrario
	 */
	public boolean hayPremio() {
		return (fPremios.length > 0);
	}

	/**
	 * Retorna un premio al azar de los disponibles, retorna nulo si no hay premios.
	 * 
	 * @return un premio al azar, null si no hay premios.
	 */
	public Entidad getPremioRandom() {
		Entidad premio = null;
		Random rand;

		// Se genera un premio al azar de los disponibles, si es que existe
		if (fPremios.length > 0) {
			rand = new Random();
			premio = fPremios[rand.nextInt(fPremios.length)].crearEntidad();
		}

		return premio;
	}

	/**
	 * Decrementa en uno (1) la cantidad de infectados. Y segun la cantidad de
	 * infectados restante se avanzando de tanda o nivel.
	 */
	public void decrementarInfectados() {
		cantidad_infectados--;
		cant_primeraTanda--;
		if (cantidad_infectados == 0) {
			siguienteNivel();
		} else {
			if (cant_primeraTanda == 0) {
				segundaTanda();
			}
		}
	}

	// Getters/ Setters
	/**
	 * Settea el juego actual con el que es pasado por parametro.
	 * 
	 * @param j juego nuevo
	 */
	public void setJuego(Juego j) {
		juego = j;
	}
}
