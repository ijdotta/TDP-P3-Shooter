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

public class VisitorNormalizarInfectado extends Visitor {

	@Override
	public void visitAlpha(Alpha a) {
		this.descongelarInfectado(a);
	}

	@Override
	public void visitBeta(Beta b) {
		this.descongelarInfectado(b);
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

	private void descongelarInfectado(Infectado enti) {
		// Pongo su estado en normal
		enti.setState(new InfectadoDefaultState(enti));

		System.out.println("***Descongelado*** " + enti.toString());
	}
}
