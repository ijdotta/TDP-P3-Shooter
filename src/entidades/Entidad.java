package entidades;

import java.awt.Rectangle;

import movimientos.Movimiento;

public abstract class Entidad
{
	protected Rectangle hitbox;
	protected Movimiento movimiento;
	protected int velocidad;
	
	public Rectangle getHitbox()
	{
		return hitbox;
	}
	
	public int getVelocidad()
	{
		return velocidad;
	}
}
