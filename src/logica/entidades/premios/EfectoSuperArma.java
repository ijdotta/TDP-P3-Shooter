package logica.entidades.premios;

import logica.Juego;
import logica.entidades.premios.timers.TimerSuperArma;
import logica.entidadesGraficas.premios.GraficoSuperArma;
import logica.visitors.Visitor;
import logica.visitors.premios.VisitorSuperArma;

public class EfectoSuperArma extends EfectoTemporal {

	// Atributos
	protected TimerSuperArma timer_super_arma;
	public static final int DURACION = 8000;

	// Constructor
	public EfectoSuperArma(Juego j) {
		super(j);

		velocidad = 5;

		entidadGrafica = new GraficoSuperArma(30, 30);

		visitor = new VisitorSuperArma(this);

		timer_super_arma = TimerSuperArma.getInstance();
	}

	// Metodos
	@Override
	public void accept(Visitor v) {
		v.visitSuperArma(this);
	}

	public TimerSuperArma getTimerSuperArma() {
		return timer_super_arma;
	}
}
