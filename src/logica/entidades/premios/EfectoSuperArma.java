package logica.entidades.premios;

import logica.Juego;
import logica.entidades.premios.timers.TimerSuperArma;
import logica.entidadesGraficas.premios.GraficoSuperArma;
import logica.visitors.Visitor;
import logica.visitors.premios.VisitorSuperArma;
/**
 * Class EfectoSuperArma Implementacion de un premio super arma.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class EfectoSuperArma extends EfectoTemporal {

	// Atributos
	public static final int DURACION = 8000;

	// Constructor
	/**
	 * Inicia el premio cuarentena con 5 de velocidad, su sprite grafico, su visitor y su timer.
	 * @param j juego a conocer
	 */
	public EfectoSuperArma(Juego j) {
		super(j);

		velocidad = 5;

		entidadGrafica = new GraficoSuperArma(30, 30);

		visitor = new VisitorSuperArma(this);

		timer = TimerSuperArma.getInstance();
	}

	// Metodos
	@Override
	public void accept(Visitor v) {
		v.visitSuperArma(this);
	}
}
