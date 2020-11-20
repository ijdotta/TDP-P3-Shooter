package visitors.premios;

import entidades.estados.InfectadoDefaultState;
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

public class VisitorNormalizarInfectado extends Visitor{

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
		
		System.out.println("***Descongelado*** "+enti.toString());
	}
}
