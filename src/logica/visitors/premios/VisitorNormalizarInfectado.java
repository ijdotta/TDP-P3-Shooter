package logica.visitors.premios;

import logica.entidades.estados.InfectadoDefaultState;
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
 * Class VisitorNormalizarInfectado Implementacion de una entidad que visita al efecto de normalizar a un infectado.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class VisitorNormalizarInfectado implements Visitor {

	// Metodos
	/**
	 * Descongela a los infectados tipo alpha
	 */
	public void visitAlpha(Alpha a) {
		this.descongelarInfectado(a);
	}

	/**
	 * Descongela a los infectados tipo beta
	 */
	public void visitBeta(Beta b) {
		this.descongelarInfectado(b);
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
	 * Congela una entidad
	 * @param enti entidad a congelar
	 */
	private void descongelarInfectado(Infectado enti) {
		// Pongo su estado en normal
		enti.setState(new InfectadoDefaultState(enti));
	}
}
