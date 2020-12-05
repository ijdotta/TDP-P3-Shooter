package logica.entidadesGraficas.jugador;

import logica.entidadesGraficas.EntidadGrafica;

/**
 * Class GraficoJugador Implementacion de la parte grafica de un jugador.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class GraficoJugador extends EntidadGrafica {
	// Constructor
	/**
	 * Inicia el grafico del jugador con su sprite grafico representativo.
	 * 
	 * @param w ancho
	 * @param h alto
	 */
	public GraficoJugador(int w, int h) {
		super("/img/jugador_jugador.png", w, h);
	}
}
