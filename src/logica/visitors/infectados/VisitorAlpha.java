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
 * Class VisitorAlpha Implementacion de una entidad que visita a un infectado tipo alpha.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class VisitorAlpha implements Visitor {

	// Atributos de instancia
	private Alpha alpha;

	// Constructor
	/**
	 * Inicia el visitor conociendo a su infectado alpha
	 * @param a infectado alpha a conocer
	 */
	public VisitorAlpha(Alpha a) {
		alpha = a;
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
	 * el infectado alpha daña al jugador
	 */
	public void visitJugador(Jugador j) {
		j.damage(alpha);
	}
}
