package entidades.premios;

import entidades.premios.timers.TimerCuarentena;
import entidadesGraficas.premios.GraficoCuarentena;
import logica.Juego;
import visitors.Visitor;

public class EfectoCuarentena extends EfectoTemporal {

	// Atributos
	protected TimerCuarentena timer_cuarentena;
	public static final int DURACION = 4000;
	// Constructor
	public EfectoCuarentena(Juego j) {
		super(j);
		
		velocidad = 5;
		
		entidadGrafica = new GraficoCuarentena(30, 30);
		timer_cuarentena = TimerCuarentena.getInstance();
	}
	// Metodos
	@Override
	public void accept(Visitor v) {
		v.visitCuarentena(this);
	}

	public TimerCuarentena getTimerCuarentena() {
		return timer_cuarentena;
	}
}
