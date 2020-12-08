package logica.visitors.premios;

import logica.entidades.estados.InfectadoCongeladoState;
import logica.entidades.infectados.Alpha;
import logica.entidades.infectados.Beta;
import logica.entidades.infectados.Infectado;
import logica.entidades.jugador.Jugador;
import logica.entidades.premios.EfectoCuarentena;
import logica.entidades.premios.EfectoPocion;
import logica.entidades.premios.EfectoSuperArma;
import logica.entidades.proyectiles.Proyectil_Infectado;
import logica.entidades.proyectiles.Proyectil_Jugador;
import logica.visitors.Visitor;
/**
 * Class VisitorAplicarCuarentena Implementacion de una entidad que visita al efecto de un premio cuarentena.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class VisitorAplicarCuarentena implements Visitor {

	/**
	 * Congela al infectado de tipo alpha
	 */
	public void visitAlpha(Alpha a) {
		this.congelarInfectado(a);
	}

	/**
	 * Congela al infectado de tipo beta
	 */
	public void visitBeta(Beta b) {
		this.congelarInfectado(b);
	}

	/**
	 * no tiene interaccion
	 */
	public void visitCuarentena(EfectoCuarentena ec) {}

	/**
	 * no tiene interaccion
	 */
	public void visitPocion(EfectoPocion ep) {}

	/**
	 * no tiene interaccion
	 */
	public void visitSuperArma(EfectoSuperArma esa) {}

	/**
	 * no tiene interaccion
	 */
	public void visitProjectilJ(Proyectil_Jugador pj) {}

	/**
	 * no tiene interaccion
	 */
	public void visitProjectilI(Proyectil_Infectado pi) {}

	/**
	 * no tiene interaccion
	 */
	public void visitJugador(Jugador j) {}
	
	/**
	 * Congela al infectado
	 * @param inf infectado a congelar
	 */
	private void congelarInfectado(Infectado inf) {
		// Pongo su estado en congelado
		inf.setState(new InfectadoCongeladoState(inf));
	}
}
