package logica.entidadesGraficas.background;

import logica.entidadesGraficas.EntidadGrafica;

/**
 * Class Background Implementacion de la parte grafica del escenario.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class Background extends EntidadGrafica {
	// Constructor
	/**
	 * Inicia el grafico del proyectil del jugador con su sprite grafico
	 * representativo.
	 * 
	 * @param w ancho
	 * @param h alto
	 */
	public Background(int w, int h) {
		super("/img/background_Scenery43.png", w, h);
	}

}
