package logica.movimientos;

import logica.entidades.Entidad;

public class MVertical extends Movimiento
{
	public static final int UP = -1;
	public static final int DOWN = 1;

	public MVertical(Entidad e, int d)
	{
		super(e, d);
	}
	
	public void mover()
	{		
		int x = (int) entidad.getX();
		int y = (int) (entidad.getY() + entidad.getVelocidad() * direccion);
		entidad.setLocation(x, y);
	}
}
