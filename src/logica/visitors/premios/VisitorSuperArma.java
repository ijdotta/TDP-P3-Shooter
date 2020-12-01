package logica.visitors.premios;

import logica.entidades.infectados.Alpha;
import logica.entidades.infectados.Beta;
import logica.entidades.jugador.Jugador;
import logica.entidades.premios.EfectoCuarentena;
import logica.entidades.premios.EfectoPocion;
import logica.entidades.premios.EfectoSuperArma;
import logica.entidades.premios.timers.TimerP;
import logica.entidades.proyectiles.Proyectil_Infectado;
import logica.entidades.proyectiles.Proyectil_Jugador;
import logica.factories.proyectiles.ProyectilFuerteFactory;
import logica.visitors.Visitor;

public class VisitorSuperArma extends Visitor {
	// Atributos de instancia
	private EfectoSuperArma eSuperArma;

	// Constructor
	public VisitorSuperArma(EfectoSuperArma esa) {
		eSuperArma = esa;
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
		TimerP tsa;

		// Inicio/ Reinicio el timer
		tsa = eSuperArma.getTimerSuperArma();

		if (tsa.isRunning()) {
			tsa.restart();
		} else {
			// Seteo el nuevo proyectil mas fuerte
			j.setProyectil(new ProyectilFuerteFactory(eSuperArma.getJuego()));

			tsa.start();
		}

		// El premio muere
		eSuperArma.setVida(-1);

	}

}
