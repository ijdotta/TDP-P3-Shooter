package logica.entidades.premios;

import logica.Juego;
import logica.entidades.premios.timers.TimerCuarentena;
import logica.entidadesGraficas.premios.GraficoCuarentena;
import logica.visitors.Visitor;
import logica.visitors.premios.VisitorCuarentena;
/**
 * Class EfectoCuarentena Implementacion de un premio cuarentena.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class EfectoCuarentena extends EfectoTemporal {

	// Atributos
	public static final int DURACION = 4000;

	// Constructor
	/**
	 * Inicia el premio cuarentena con 5 de velocidad, su sprite grafico, su visitor y su timer.
	 * @param j juego a conocer
	 */
	public EfectoCuarentena(Juego j) {
		super(j);

		velocidad = 5;

		entidadGrafica = new GraficoCuarentena(30, 30);

		visitor = new VisitorCuarentena(this);

		timer = TimerCuarentena.getInstance();
	}

	// Metodos
	@Override
	public void accept(Visitor v) {
		v.visitCuarentena(this);
	}
}
