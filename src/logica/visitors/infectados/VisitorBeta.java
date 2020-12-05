package logica.visitors.infectados;

import logica.entidades.infectados.Alpha;
import logica.entidades.infectados.Beta;
import logica.entidades.jugador.Jugador;
import logica.entidades.premios.EfectoCuarentena;
import logica.entidades.premios.EfectoPocion;
import logica.entidades.premios.EfectoSuperArma;
import logica.entidades.proyectiles.Proyectil_Infectado;
import logica.entidades.proyectiles.Proyectil_Jugador;
import logica.visitors.Visitor;
/**
 * Class VisitorBeta Implementacion de una entidad que visita a un infectado tipo beta.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class VisitorBeta implements Visitor {

	// Atributos de instancia
	private Beta beta;

	// Constructor
	/**
	 * Inicia el visitor conociendo a su infectado beta
	 * @param b infectado beta a conocer
	 */
	public VisitorBeta(Beta b) {
		beta = b;
	}

	// Metodos
	/**
	 * no tiene interaccion
	 */
	public void visitAlpha(Alpha a) {}

	/**
	 * no tiene interaccion
	 */
	public void visitBeta(Beta b) {}

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
	 * el infectado beta daña al jugador
	 */
	public void visitJugador(Jugador j) {
		j.damage(beta);
	}
}
