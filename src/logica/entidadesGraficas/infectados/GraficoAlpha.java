package logica.entidadesGraficas.infectados;

import logica.entidadesGraficas.EntidadGrafica;

/**
 * Class GraficoAlpha Implementacion de la parte grafica de un infectado de tipo
 * alpha.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class GraficoAlpha extends EntidadGrafica {
	// Constructor
	/**
	 * Inicia el grafico del infectado tipo alpha con su sprite grafico
	 * representativo.
	 * 
	 * @param w ancho
	 * @param h alto
	 */
	public GraficoAlpha(int w, int h) {
		super("/img/infectado_alpha.png", w, h);
	}

}
