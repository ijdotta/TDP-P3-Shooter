package visitors.jugador;

import entidades.Entidad;
import entidades.infectados.Alpha;
import entidades.infectados.Beta;
import entidades.jugador.Jugador;
import entidades.premios.EfectoCuarentena;
import entidades.premios.EfectoPocion;
import entidades.premios.EfectoSuperArma;
import entidades.premios.timers.TimerCuarentena;
import entidades.premios.timers.TimerSuperArma;
import entidades.proyectiles.Proyectil_Infectado;
import entidades.proyectiles.Proyectil_Jugador;
import factories.EntidadFactory;
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
		TimerCuarentena tc;

		// Congelar a los infectados
		for (Entidad e : ec.getJuego().getEntidades()) {
			e.accept(new VisitorAplicarCuarentena());
		}

		// Iniciar/ Reiniciar Timer
		tc = ec.getTimerCuarentena();
		
		if (tc.isRunning()) {
			tc.restart();
		} else {
			tc.start();
		}

		// El premio muere
		ec.setVida(-1);
	}

	@Override
	public void visitPocion(EfectoPocion ep) {
		int vida_aumentada = jugador.getVida() + 25;

		// Aumentar vida con un tope de 100
		if (vida_aumentada > 100) {
			jugador.setVida(100);
		} else {
			jugador.setVida(vida_aumentada);
		}
		// Actualizar el label de vida
		jugador.getJuego().getGui().actualizarLabelVidaJugador("Vida_Jugador: " + jugador.getVida());

		// El premio muere
		ep.setVida(-1);
	}

	@Override
	public void visitSuperArma(EfectoSuperArma esa) {
		TimerSuperArma tsa;
		// Guardo el proyectil anterior
		//EntidadFactory proyectil_anterior = jugador.getProyectil();
		
		// Seteo el nuevo proyectil mas fuerte
		jugador.setProyectil(new ProyectilFuerteFactory(jugador.getJuego()));
		
		// Inicio/ Reinicio el timer
		tsa = esa.getTimerSuperArma();
		
		if (tsa.isRunning()) {
			tsa.restart();
		} else {
			tsa.start();
		}
		
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
