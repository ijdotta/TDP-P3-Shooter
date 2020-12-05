package logica.movimientos;

import logica.entidades.Entidad;
/**
 * Abstract Class Movimiento Implementacion y definicion de como una entidad debe moverse.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public abstract class Movimiento {
	// Atributos de instancia
	protected Entidad entidad;
	protected int direccion;
	public static final int STOP = 0;
	
	// Constructor
	/**
	 * Inicia el movimiento de una entidad sin direccion.
	 * 
	 * @param e Entidad que se quiere mover en el mapa
	 */
	public Movimiento(Entidad e) {
		entidad = e;
		direccion = STOP;
	}

	/**
	 * Inicia el movimiento de una entidad en una direccion dada por parametro.
	 * 
	 * @param e Entidad que se quiere mover en el mapa
	 * @param d Direccion que toma la entidad
	 */
	public Movimiento(Entidad e, int d) {
		entidad = e;
		direccion = d;
	}

	// Metodos
	/**
	 * Comportamiento que toma una entidad al querer moverse
	 */
	public abstract void mover();

	/**
	 * Retorna la direccion actual
	 * @return direccion actual
	 */
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int d) {
		direccion = d;
	}

	public void setEntidad(Entidad e) {
		entidad = e;
	}
}
