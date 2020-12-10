package logica.entidades.proyectiles;

import logica.Juego;
import logica.entidadesGraficas.proyectiles.GraficoProyectilFuerte;
import logica.visitors.Visitor;

/**
 * Class Proyectil_Fuerte Implementacion del proyectil fuerte.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class Proyectil_Fuerte extends Proyectil_Jugador {
	// Constructor
	/**
	 * Inicia el proyectil fuerte con su sprite grafico, 13 de velocidad y 34 de
	 * daño.
	 * 
	 * @param j juego a conocer
	 */
	public Proyectil_Fuerte(Juego j) {
		super(j);
		entidadGrafica = new GraficoProyectilFuerte();
		velocidad = 13;
		damage = 34;
	}
	// Metodos
	@Override
	public void accept(Visitor v) {
		v.visitProjectilJ(this);
	}

}
