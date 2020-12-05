package logica.entidadesGraficas.premios;

import logica.entidadesGraficas.EntidadGrafica;

/**
 * Class GraficoCuarentena Implementacion de la parte grafica de un premio
 * cuarentena.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class GraficoCuarentena extends EntidadGrafica {
	// Constructor
	/**
	 * Inicia el grafico del premio cuarentena con su sprite grafico representativo.
	 * 
	 * @param w ancho
	 * @param h alto
	 */
	public GraficoCuarentena(int w, int h) {
		super("/img/premio_cuarentena.png", w, h);
	}

}
