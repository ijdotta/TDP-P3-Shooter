package logica.entidadesGraficas.premios;

import logica.entidadesGraficas.EntidadGrafica;

/**
 * Class GraficoSuperArma Implementacion de la parte grafica de un premio super
 * arma.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class GraficoSuperArma extends EntidadGrafica {
	// Constructor
	/**
	 * Inicia el grafico del premio super arma con su sprite grafico representativo.
	 * 
	 * @param w ancho
	 * @param h alto
	 */
	public GraficoSuperArma(int w, int h) {
		super("/img/premio_super_arma.png", w, h);
	}

}
