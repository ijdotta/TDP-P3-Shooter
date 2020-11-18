package movimientos;

import javax.swing.JLabel;

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
		JLabel label = entidad.getEntidadGrafica().getLabelImagen();
		
		x = (int) (label.getX() + entidad.getVelocidad() * direccion);
		
		// Si esta adentro del escenario lo sigo moviendo
		if ( (x >= 0) && ((x + entidad.getEntidadGrafica().getLabelImagen().getWidth() + 15) <= entidad.getJuego().getGui().getWidth()) ) {
			y = (int) label.getY();
			
			label.setLocation(x, y);
		}		
	}
}
