package logica.movimientos;

import logica.entidades.Entidad;

/**
 * Class MHorizontal Implementacion de un movimiento horizontal.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class MHorizontal extends Movimiento {
	// Atributos de instancia
	public static final int RIGHT = 1;
	public static final int LEFT = -1;

	// Constructor
	/**
	 * Inicia el movimiento horizontal
	 * 
	 * @param e Entidad que se quiere mover en el mapa
	 * @param d Direccion en la que se quiere mover
	 */
	public MHorizontal(Entidad e, int d) {
		super(e, d);
	}

	// Metodos
	/**
	 * Mueve a la entidad actual en el eje "x" segun la direccion actual y la
	 * velocidad de la entidad. Mantiene a la entidad dentro del escenario.
	 */
	public void mover() {
		int x, y;

		x = (int) (entidad.getX() + entidad.getVelocidad() * direccion);

		// Si esta adentro del escenario lo sigo moviendo
		if ((x >= 0) && ((x + entidad.getWidth()) <= entidad.getJuego().escenarioWidth())) {
			y = (int) entidad.getY();

			entidad.setLocation(x, y);
		}
	}
}
