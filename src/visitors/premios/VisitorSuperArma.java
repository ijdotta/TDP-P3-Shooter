package visitors.premios;

import entidades.infectados.Alpha;
import entidades.infectados.Beta;
import entidades.jugador.Jugador;
import entidades.premios.EfectoCuarentena;
import entidades.premios.EfectoPocion;
import entidades.premios.EfectoSuperArma;
import entidades.premios.timers.TimerP;
import entidades.proyectiles.Proyectil_Infectado;
import entidades.proyectiles.Proyectil_Jugador;
import factories.proyectiles.ProyectilFuerteFactory;
import visitors.Visitor;

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
