package movimientos;

import javax.swing.JLabel;

import entidades.Entidad;

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
		JLabel label = entidad.getEntidadGrafica().getLabelImagen();
		
		int x = (int) label.getX();
		int y = (int) (label.getY() + entidad.getVelocidad() * direccion);
		label.setLocation(x, y);
	}
}
