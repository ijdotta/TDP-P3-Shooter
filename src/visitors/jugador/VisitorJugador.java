package visitors.jugador;

import entidades.Entidad;
import entidades.infectados.Alpha;
import entidades.infectados.Beta;
import entidades.jugador.Jugador;
import entidades.premios.EfectoCuarentena;
import entidades.premios.EfectoPocion;
import entidades.premios.EfectoSuperArma;
import entidades.premios.timers.TimerCuarentena;
import entidades.premios.timers.TimerP;
import entidades.premios.timers.TimerSuperArma;
import entidades.proyectiles.Proyectil_Infectado;
import entidades.proyectiles.Proyectil_Jugador;
import factories.proyectiles.ProyectilFuerteFactory;
import visitors.Visitor;
import visitors.premios.VisitorAplicarCuarentena;

public class VisitorJugador extends Visitor {
	// Atributos de instancia
	private Jugador jugador;

	// Constructor
	public VisitorJugador(Jugador j) {
		jugador = j;
	}

	// Metodos
	@Override
	public void visitAlpha(Alpha a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitBeta(Beta b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitCuarentena(EfectoCuarentena ec) {

	}

	@Override
	public void visitPocion(EfectoPocion ep) {

	}

	@Override
	public void visitSuperArma(EfectoSuperArma esa) {

	}

	@Override
	public void visitProjectilJ(Proyectil_Jugador pj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitProjectilI(Proyectil_Infectado pi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitJugador(Jugador j) {
		// TODO Auto-generated method stub

	}
}
