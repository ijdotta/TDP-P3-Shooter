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
	 */
	public GraficoAlpha() {
		super("/img/infectado_alpha.png", 60, 56);
	}

}
