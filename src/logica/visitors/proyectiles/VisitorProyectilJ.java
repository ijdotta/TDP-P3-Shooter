package logica.visitors.proyectiles;

import logica.entidades.Entidad;
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
 * Class VisitorProyectilJ Implementacion de una entidad que visita a un infectado tipo beta.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class VisitorProyectilJ implements Visitor {

	// Atributos de instancia
	private Proyectil_Jugador proyectilJugador;
	
	// Constructor
	public VisitorProyectilJ(Proyectil_Jugador pj)
	{
		proyectilJugador = pj;
	}

	// Metodos
	/**
	 * daña al infectado tipo alpha
	 */
	public void visitAlpha(Alpha a) {
		this.damageInfectado(a);
	}

	/**
	 * daña al infectado tipo beta
	 */
	public void visitBeta(Beta b) {
		this.damageInfectado(b);
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
	 * daña al infectado
	 * @param inf infectado que se quiere dañar
	 */
	private void damageInfectado(Entidad inf) {
		inf.damage(proyectilJugador);
		
		// el proyectil muere
		proyectilJugador.destruir();		
	}

}
