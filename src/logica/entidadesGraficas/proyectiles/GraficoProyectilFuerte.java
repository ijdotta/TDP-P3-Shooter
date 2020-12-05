package logica.entidadesGraficas.proyectiles;

import logica.entidadesGraficas.EntidadGrafica;

/**
 * Class GraficoProyectilFuerte Implementacion de la parte grafica de un
 * proyectil fuerte.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class GraficoProyectilFuerte extends EntidadGrafica {
	// Constructor
	/**
	 * Inicia el grafico del proyectil fuerte con su sprite grafico representativo.
	 * 
	 * @param w ancho
	 * @param h alto
	 */
	public GraficoProyectilFuerte(int w, int h) {
		super("/img/proyectil_fuerte.png", w, h);
	}

}
