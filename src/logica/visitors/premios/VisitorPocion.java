package logica.visitors.premios;

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
 * Class VisitorPocion Implementacion de una entidad que visita a un premio pocion.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class VisitorPocion implements Visitor {
	// Atributos de instancia
	private EfectoPocion ePocion;

	// Constructor
	/**
	 * Inicia el visitor conociendo a su premio pocion
	 * @param ep premio pocion a conocer
	 */
	public VisitorPocion(EfectoPocion ep) {
		ePocion = ep;
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
	 * cura al jugador
	 */
	public void visitJugador(Jugador j) {
		int vida_aumentada = j.getVida() + EfectoPocion.CURACION;

		// Aumentar vida con un tope de 100
		if (vida_aumentada > 100) {
			j.setVida(100);
		} else {
			j.setVida(vida_aumentada);
		}

		// El premio muere
		ePocion.destruir();
	}

}
