package logica.movimientos;

import logica.entidades.Entidad;
/**
 * Class MVertical Implementacion de un movimiento vertical.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class MVertical extends Movimiento {
	// Atributos de instancia
	public static final int UP = -1;
	public static final int DOWN = 1;

	// Constructor
	/**
	 * Inicia el movimiento vertical
	 * 
	 * @param e Entidad que se quiere mover en el mapa
	 * @param d Direccion en la que se quiere mover
	 */
	public MVertical(Entidad e, int d) {
		super(e, d);
	}

	// Metodos
	/**
	 * Mueve a la entidad actual en el eje "y" segun la direccion actual y la
	 * velocidad de la entidad
	 */
	public void mover() {
		int x = (int) entidad.getX();
		int y = (int) (entidad.getY() + entidad.getVelocidad() * direccion);
		entidad.setLocation(x, y);
	}
}
