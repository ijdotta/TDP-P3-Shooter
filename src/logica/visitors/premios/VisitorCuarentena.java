package logica.visitors.premios;

import logica.entidades.Entidad;
import logica.entidades.infectados.Alpha;
import logica.entidades.infectados.Beta;
import logica.entidades.jugador.Jugador;
import logica.entidades.premios.EfectoCuarentena;
import logica.entidades.premios.EfectoPocion;
import logica.entidades.premios.EfectoSuperArma;
import logica.entidades.premios.timers.TimerP;
import logica.entidades.proyectiles.Proyectil_Infectado;
import logica.entidades.proyectiles.Proyectil_Jugador;
import logica.visitors.Visitor;

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
