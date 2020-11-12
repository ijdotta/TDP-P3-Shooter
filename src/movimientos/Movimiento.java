package movimientos;

import entidades.Entidad;

public abstract class Movimiento
{
	// Atributos de instancia
	protected Entidad entidad;
	protected int direccion;
	
	// Constructor
	public Movimiento (Entidad e, int d)
	{
		entidad = e;
		direccion = d;
	}
	
	// Metodos
	public int getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(int d)
	{
		this.direccion = d;
	}
	
	public abstract void mover();
}
