package logica.entidadesGraficas.proyectiles;

import logica.entidadesGraficas.EntidadGrafica;

/**
 * Class GraficoProyectilJugador Implementacion de la parte grafica de un
 * proyectil del jugador.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class GraficoProyectilJugador extends EntidadGrafica {

	// Constructor
	/**
	 * Inicia el grafico del proyectil del jugador con su sprite grafico
	 * representativo.
	 * 
	 * @param w ancho
	 * @param h alto
	 */
	public GraficoProyectilJugador(int w, int h) {
		super("/img/proyectil_jugador.png", w, h);
	}

}
