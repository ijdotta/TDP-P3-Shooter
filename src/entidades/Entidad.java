package entidades;

import java.awt.Rectangle;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Entidad
{
	protected EntidadGrafica entidadGrafica;
	protected Movimiento movimiento;
	protected int velocidad;
	
	public int getVelocidad()
	{
		return velocidad;
	}
	
	public EntidadGrafica getEntidadGrafica()
	{
		return entidadGrafica;
	}
	
	public int getMovimiento() {
		return velocidad;
	}
}
