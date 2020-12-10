package logica.entidades.proyectiles;

import logica.Juego;
import logica.entidadesGraficas.proyectiles.GraficoProyectilJugador;
import logica.movimientos.MVertical;
import logica.visitors.Visitor;
import logica.visitors.proyectiles.VisitorProyectilJ;

/**
 * Class Proyectil_Jugador Implementacion del proyectil de un jugador.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class Proyectil_Jugador extends Proyectil {

	// Constructor
	/**
	 * Inicia el proyectil del jugador con un movimiento hacia arriba, su sprite
	 * grafico, su visitor, 15 de velocidad, 15 de daño.
	 * 
	 * @param j juego a conocer
	 */
	public Proyectil_Jugador(Juego j) {
		super(j);
		movimiento = new MVertical(this, MVertical.UP);
		entidadGrafica = new GraficoProyectilJugador();
		visitor = new VisitorProyectilJ(this);
		velocidad = 15;
		damage = 15;
	}

	// Metodos
	@Override
	public void accept(Visitor v) {
		v.visitProjectilJ(this);
	}

}
