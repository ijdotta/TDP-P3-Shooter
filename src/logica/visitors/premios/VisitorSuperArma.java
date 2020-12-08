package logica.visitors.premios;

import logica.entidades.infectados.Alpha;
import logica.entidades.infectados.Beta;
import logica.entidades.jugador.Jugador;
import logica.entidades.premios.EfectoCuarentena;
import logica.entidades.premios.EfectoPocion;
import logica.entidades.premios.EfectoSuperArma;
import logica.entidades.premios.timers.TimerP;
import logica.entidades.proyectiles.Proyectil_Infectado;
import logica.entidades.proyectiles.Proyectil_Jugador;
import logica.factories.proyectiles.ProyectilFuerteFactory;
import logica.visitors.Visitor;

/**
 * Class VisitorSuperArma Implementacion de una entidad que visita a un premio
 * super arma.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class VisitorSuperArma implements Visitor {
	// Atributos de instancia
	private EfectoSuperArma eSuperArma;

	// Constructor
	public VisitorSuperArma(EfectoSuperArma esa) {
		eSuperArma = esa;
	}

	// Metodos
	/**
	 * no tiene interaccion
	 */
	public void visitAlpha(Alpha a) {
	}

	/**
	 * no tiene interaccion
	 */
	public void visitBeta(Beta b) {
	}

	/**
	 * no tiene interaccion
	 */
	public void visitCuarentena(EfectoCuarentena ec) {
	}

	/**
	 * no tiene interaccion
	 */
	public void visitPocion(EfectoPocion ep) {
	}

	/**
	 * no tiene interaccion
	 */
	public void visitSuperArma(EfectoSuperArma esa) {
	}

	/**
	 * no tiene interaccion
	 */
	public void visitProjectilJ(Proyectil_Jugador pj) {
	}

	/**
	 * no tiene interaccion
	 */
	public void visitProjectilI(Proyectil_Infectado pi) {
	}

	/**
	 * Le da al jugador un proyectil mas fuerte, inicia el timer para devolverlo a
	 * su proyectil comun. Si ya tenia el efecto, reinicia el timer.
	 */
	public void visitJugador(Jugador j) {
		TimerP tsa;

		// Inicio/ Reinicio el timer
		tsa = eSuperArma.getTimer();

		if (tsa.isRunning()) {
			tsa.restart();
		} else {
			// Seteo el nuevo proyectil mas fuerte
			j.setProyectil(new ProyectilFuerteFactory(eSuperArma.getJuego()));

			tsa.start();
		}

		// El premio muere
		eSuperArma.destruir();

	}

}
