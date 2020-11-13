package movimientos;

import entidades.Entidad;

public abstract class Movimiento
{
	// Atributos de instancia
	protected Entidad entidad;
	protected int direccion;
	
	// Constructor
	/**
	 * Inicia el movimiento de una entidad hacia direcciones negativas.
	 * @param e Entidad que se quiere mover en el mapa
	 */
	public Movimiento (Entidad e)
	{
		entidad = e;
		direccion = -1;
	}
	/**
	 * Inicia el movimiento de una entidad en una direccion dada por parametro.
	 * @param e Entidad que se quiere mover en el mapa
	 * @param d Direccion que toma la entidad
	 */
	public Movimiento (Entidad e, int d)
	{
		entidad = e;
		direccion = d;
	}
	
	// Metodos
	public abstract void mover();
	
	public int getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(int d)
	{
		direccion = d;
	}
	
	public void setEntidad(Entidad e)
	{
		entidad = e;
	}
}
