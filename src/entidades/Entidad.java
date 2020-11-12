package entidades;

import java.awt.Rectangle;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Entidad
{	
	protected Rectangle hitbox;
	protected EntidadGrafica entidadGrafica;
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
