package visitors.premios;

import entidades.estados.InfectadoCongeladoState;
import entidades.infectados.Alpha;
import entidades.infectados.Beta;
import entidades.infectados.Infectado;
import entidades.jugador.Jugador;
import entidades.premios.EfectoCuarentena;
import entidades.premios.EfectoPocion;
import entidades.premios.EfectoSuperArma;
import entidades.proyectiles.Proyectil_Infectado;
import entidades.proyectiles.Proyectil_Jugador;
import visitors.Visitor;

public class VisitorAplicarCuarentena extends Visitor {

	@Override
	public void visitAlpha(Alpha a) {
		this.congelarInfectado(a);
	}

	@Override
	public void visitBeta(Beta b) {
		this.congelarInfectado(b);
	}

	@Override
	public void visitCuarentena(EfectoCuarentena ec) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitPocion(EfectoPocion ep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitSuperArma(EfectoSuperArma esa) {
		// TODO Auto-generated method stub

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

	private void congelarInfectado(Infectado enti) {
		// Guardo el estado anterior
		// State state_anterior = enti.getState();
		// Pongo su estado en congelado
		enti.setState(new InfectadoCongeladoState(enti));

		System.out.println("***Congelado*** " + enti.toString());
	}
}
