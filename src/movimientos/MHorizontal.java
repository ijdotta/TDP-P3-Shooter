package movimientos;

import entidades.Entidad;

public class MHorizontal extends Movimiento
{
	public static final int RIGHT = 1;
	public static final int LEFT = -1;

	public MHorizontal(Entidad e, int d)
	{
		super(e, d);
	}

	public void mover() 
	{
		int x,y;
		
		x = (int) (entidad.getX() + entidad.getVelocidad() * direccion);
		
		// Si esta adentro del escenario lo sigo moviendo
		if ( (x >= 0) && ((x + entidad.getWidth()) <= entidad.getJuego().escenarioWidth() )) {
			y = (int) entidad.getY();
			
			entidad.setLocation(x, y);
		}		
	}
}
