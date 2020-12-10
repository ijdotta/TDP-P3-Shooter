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
	// Atributos de instancia
	int rango;

	// Constructor
	/**
	 * Inicia el proyectil del infectado con un movimiento hacia abajo, su sprite
	 * grafico, su visitor, 10 de velocidad, 15 de daño y 300 de rango.
	 * 
	 * @param j juego a conocer
	 */
	public Proyectil_Infectado(Juego j) {
		super(j);

		movimiento = new MVertical(this, MVertical.DOWN);
		entidadGrafica = new GraficoProyectilInfectado();
		visitor = new VisitorProyectilI(this);
		velocidad = 10;
		damage = 15;
		rango = 300;
	}

	// Metodos
	@Override
	public void accept(Visitor v) {
		v.visitProjectilI(this);
	}

	/**
	 * Moverse segun el comportamiento de su state, reducir la distancia recorrida.
	 */
	public void mover() {
		super.mover();
		rango -= velocidad;
		
		// Si ya recorrio su rango maximo, el proyectil muere
		if(rango<= 0) {
			vida = -1;
		}
	}
}
