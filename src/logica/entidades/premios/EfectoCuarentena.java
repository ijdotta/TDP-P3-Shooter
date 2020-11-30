package logica.entidades.premios;

import logica.Juego;
import logica.entidades.premios.timers.TimerCuarentena;
import logica.entidadesGraficas.premios.GraficoCuarentena;
import logica.visitors.Visitor;
import logica.visitors.premios.VisitorCuarentena;

public class EfectoCuarentena extends EfectoTemporal {

	// Atributos
	protected TimerCuarentena timer_cuarentena;
	public static final int DURACION = 4000;
	// Constructor
	public EfectoCuarentena(Juego j) {
		super(j);
		
		velocidad = 5;
		
		entidadGrafica = new GraficoCuarentena(30, 30);
		
		visitor = new VisitorCuarentena(this);
		
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
