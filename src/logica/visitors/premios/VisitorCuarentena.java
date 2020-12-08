package logica.visitors.premios;

import logica.entidades.Entidad;
import logica.entidades.infectados.Alpha;
import logica.entidades.infectados.Beta;
import logica.entidades.jugador.Jugador;
import logica.entidades.premios.EfectoCuarentena;
import logica.entidades.premios.EfectoPocion;
import logica.entidades.premios.EfectoSuperArma;
import logica.entidades.premios.timers.TimerP;
import logica.entidades.proyectiles.Proyectil_Infectado;
import logica.entidades.proyectiles.Proyectil_Jugador;
import logica.visitors.Visitor;

/**
 * Class VisitorCuarentena Implementacion de una entidad que visita a un premio
 * cuarentena.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class VisitorCuarentena implements Visitor {
	// Atributos de instancia
	private EfectoCuarentena eCuarentena;

	// Constructor
	/**
	 * Inicia el visitor conociendo a su premio cuarentena
	 * 
	 * @param ec premio cuarentena a conocer
	 */
	public VisitorCuarentena(EfectoCuarentena ec) {
		eCuarentena = ec;
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
	 * Congela a todos los infectados, iniciando el timer para descongelarlos. Si ya
	 * estaban congelados se reinicia el timer
	 */
	public void visitJugador(Jugador j) {
		TimerP tc;
		Visitor vac;

		// Iniciar/ Reiniciar Timer
		tc = eCuarentena.getTimer();

		if (tc.isRunning()) {
			tc.restart();
		} else {
			// Congelar a los infectados
			vac = new VisitorAplicarCuarentena();
			for (Entidad e : eCuarentena.getJuego().getEntidades()) {
				e.accept(vac);
			}

			tc.start();
		}

		// El premio muere
		eCuarentena.destruir();
	}

}
