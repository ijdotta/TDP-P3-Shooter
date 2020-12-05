package logica.entidadesGraficas.premios;

import logica.entidadesGraficas.EntidadGrafica;

/**
 * Class GraficoPocion Implementacion de la parte grafica de un premio pocion.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class GraficoPocion extends EntidadGrafica {
	// Constructor
	/**
	 * Inicia el grafico del premio pocion con su sprite grafico representativo.
	 * 
	 * @param w ancho
	 * @param h alto
	 */
	public GraficoPocion(int w, int h) {
		super("/img/premio_pocion.png", w, h);
	}

}
