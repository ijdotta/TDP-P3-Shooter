package logica.niveles;

import java.util.Random;

import logica.Juego;
import logica.entidades.Entidad;
import logica.factories.EntidadFactory;

public abstract class Nivel {

	// Atributos de instancia
	protected Juego juego;
	protected Nivel siguienteNivel;

	protected int cantidad_infectados;
	protected EntidadFactory[] fInfectados;
	protected EntidadFactory[] fPremios;

	// Constructor
	/**
	 * Si hacemos esto así, de alguna forma los niveles pueden reutilizar el método
	 * configurar, pero pueden ir variando las fábricas (y así, el tipo específico
	 * de infectado) desde su propio constructor. Probablemente habrpia que añadir
	 * más varables fInfectados
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
	 * ¿Se encarga de limpiar el juego y hacer que se limpie la GUI de cosas viejas
	 * del nivel anterior, para configurar el nuevo nivel?
	 */
	public void limpiar() {
		// TODO tratar de utilizar juego.limpiarEscenario()
		// como la lista de entidades es un atributo del juego es responsabilidad de el
		// limpiarla
	}

	/**
	 * Si el nivel se ganó, pasar al siguiente nivel Pidiendole al juego que limpie
	 * cualquier residuos y reposicione al jugador
	 */
	public void siguienteNivel() {
		if (siguienteNivel != null) {
			juego.limpiarEscenario();
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
	 * Decrementa en uno (1) la cantidad de infectados.
	 */
	public void decrementarInfectados() {
		cantidad_infectados--;
	}

	// Getters/ Setters
	public void setJuego(Juego j) {
		juego = j;
	}
}
