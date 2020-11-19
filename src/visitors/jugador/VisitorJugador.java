package visitors.jugador;

import entidades.Entidad;
import entidades.infectados.Alpha;
import entidades.infectados.Beta;
import entidades.jugador.Jugador;
import entidades.premios.EfectoCuarentena;
import entidades.premios.EfectoPocion;
import entidades.premios.EfectoSuperArma;
import entidades.proyectiles.Proyectil_Infectado;
import entidades.proyectiles.Proyectil_Jugador;
import visitors.Visitor;

public class VisitorJugador extends Visitor{
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
		// El premio muere
		ec.setVida(-1);
		for (Entidad e: ec.getJuego().getEntidades()){
			   //premio.accept(e.getVisitor());
			   e.accept(ec.getVisitor());
		}
	}

	@Override
	public void visitPocion(EfectoPocion ep) {
		// El premio muere
		ep.setVida(-1);
		
	}

	@Override
	public void visitSuperArma(EfectoSuperArma esa) {
		// El premio muere
		esa.setVida(-1);
		
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
