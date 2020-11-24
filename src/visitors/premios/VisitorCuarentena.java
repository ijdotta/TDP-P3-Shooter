package visitors.premios;

import entidades.Entidad;
import entidades.infectados.Alpha;
import entidades.infectados.Beta;
import entidades.jugador.Jugador;
import entidades.premios.EfectoCuarentena;
import entidades.premios.EfectoPocion;
import entidades.premios.EfectoSuperArma;
import entidades.premios.timers.TimerP;
import entidades.proyectiles.Proyectil_Infectado;
import entidades.proyectiles.Proyectil_Jugador;
import visitors.Visitor;

public class VisitorCuarentena extends Visitor {
	// Atributos de instancia
	private EfectoCuarentena eCuarentena;

	// Constructor
	public VisitorCuarentena(EfectoCuarentena ec) {
		eCuarentena = ec;
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
		TimerP tc;		

		// Iniciar/ Reiniciar Timer
		tc = eCuarentena.getTimerCuarentena();
		
		if (tc.isRunning()) {
			tc.restart();
		} else {
			// Congelar a los infectados
			for (Entidad e : eCuarentena.getJuego().getEntidades()) {
				e.accept(new VisitorAplicarCuarentena());
			}
			
			tc.start();
		}

		// El premio muere
		eCuarentena.setVida(-1);
		
	}

}
