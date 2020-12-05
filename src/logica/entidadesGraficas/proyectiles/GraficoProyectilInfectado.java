package logica.entidadesGraficas.proyectiles;

import logica.entidadesGraficas.EntidadGrafica;

/**
 * Class GraficoProyectilInfectado Implementacion de la parte grafica de un
 * proyectil del infectado.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class GraficoProyectilInfectado extends EntidadGrafica {
	// Constructor
	/**
	 * Inicia el grafico del proyectil del infectado con su sprite grafico
	 * representativo.
	 * 
	 * @param w ancho
	 * @param h alto
	 */
	public GraficoProyectilInfectado(int w, int h) {
		super("/img/proyectil_infectado.png", w, h);
	}

}
