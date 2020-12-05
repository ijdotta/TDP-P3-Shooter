package logica.entidades.proyectiles;

import logica.Juego;
import logica.entidadesGraficas.proyectiles.GraficoProyectilInfectado;
import logica.movimientos.MVertical;
import logica.visitors.Visitor;
import logica.visitors.proyectiles.VisitorProyectilI;

/**
 * Class Proyectil_Infectado Implementacion del proyectil de un infectado.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class Proyectil_Infectado extends Proyectil {
	// Constructor
	/**
	 * Inicia el proyectil del infectado con un movimiento hacia abajo, su sprite
	 * grafico, su visitor, 10 de velocidad, 15 de daño.
	 * 
	 * @param j juego a conocer
	 */
	public Proyectil_Infectado(Juego j) {
		super(j);

		movimiento = new MVertical(this, MVertical.DOWN);
		entidadGrafica = new GraficoProyectilInfectado(10, 10);
		visitor = new VisitorProyectilI(this);
		velocidad = 10;
		damage = 15;
	}

	// Metodos
	@Override
	public void accept(Visitor v) {
		v.visitProjectilI(this);
	}
}
