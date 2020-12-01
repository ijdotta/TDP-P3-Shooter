package logica.visitors.jugador;

import logica.entidades.infectados.Alpha;
import logica.entidades.infectados.Beta;
import logica.entidades.jugador.Jugador;
import logica.entidades.premios.EfectoCuarentena;
import logica.entidades.premios.EfectoPocion;
import logica.entidades.premios.EfectoSuperArma;
import logica.entidades.proyectiles.Proyectil_Infectado;
import logica.entidades.proyectiles.Proyectil_Jugador;
import logica.visitors.Visitor;

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
		a.damage(jugador);
	}

	@Override
	public void visitBeta(Beta b) {
		b.damage(jugador);
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
