package logica.entidadesGraficas.infectados;

import logica.entidadesGraficas.EntidadGrafica;

/**
 * Class GraficoBeta Implementacion de la parte grafica de un infectado tipo
 * beta.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class GraficoBeta extends EntidadGrafica {
	// Constructor
	/**
	 * Inicia el grafico del infectado tipo beta con su sprite grafico
	 * representativo.
	 * 
	 * @param w ancho
	 * @param h alto
	 */
	public GraficoBeta(int w, int h) {
		super("/img/infectado_beta.png", w, h);
	}

}
