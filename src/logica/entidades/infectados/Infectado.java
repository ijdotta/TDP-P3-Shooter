package logica.entidades.infectados;

import logica.Juego;
import logica.entidades.Personaje;
import logica.entidades.estados.InfectadoDefaultState;
import logica.factories.proyectiles.ProyectilInfectadoFactory;
import logica.movimientos.MVertical;

/**
 * Abstract Class Infectado Implementacion de un infectado en general.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public abstract class Infectado extends Personaje {
	// Constructor
	/**
	 * Inicia un infectado con 1 de velocidad, un movimiento vertical hacia abajo, un state de
	 * infectado y su fabrica de proyectiles de infectado.
	 * 
	 * @param j juego a conocer
	 */
	public Infectado(Juego j) {
		super(j);
		velocidad = 1;
		movimiento = new MVertical(this, MVertical.DOWN);
		state = new InfectadoDefaultState(this);
		proyectil = new ProyectilInfectadoFactory(juego);
	}

	// Metodos
	/**
	 * Si el infectado esta out of bounds me vuelvo a reposicionar
	 */
	public void outOfBounds() {
		if (this.checkOutOfBounds()) {
			juego.reposicionarInfectado(this);
		}
	}

}