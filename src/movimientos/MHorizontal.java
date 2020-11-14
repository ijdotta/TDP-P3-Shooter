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
		JLabel label = entidad.getEntidadGrafica().getLabelImagen();
		
		int x = (int) (label.getX() + entidad.getVelocidad() * direccion);
		int y = (int) label.getY();
		label.setLocation(x, y);
	}
}
