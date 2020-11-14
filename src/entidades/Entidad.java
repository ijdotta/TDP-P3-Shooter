package entidades;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;
import visitors.Visitor;
import visitors.VisitorNulo;

public abstract class Entidad {
	// Atributos de instancia
	protected EntidadGrafica entidadGrafica;
	protected Movimiento movimiento;
	protected int velocidad;
	protected Visitor visitor;
	
	// Constructor
	/**
	 * 
	 * @param v Movimiento que se va a utilizar
	 * @param eg Velocidad
	 * @param m Entidad Grafica
	 */
	public Entidad(EntidadGrafica eg, Movimiento m, int v) {
		entidadGrafica = eg;
		movimiento = m;
		velocidad = v;
		visitor = new VisitorNulo();
	}

	// Metodos
	public abstract void accept(Visitor v);
	
	public void setEntidadGrafica(EntidadGrafica eg) {
		entidadGrafica = eg;
	}

	public void setMovimiento(Movimiento m) {
		movimiento = m;
	}

	public void setVelocidad(int v) {
		velocidad = v;
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}
	
	public Movimiento getMovimiento() {
		return movimiento;
	}
	
	public Visitor getVisitor()
	{
		return visitor;
	}
	
	public void setVisitor(Visitor v)
	{
		visitor = v;
	}
}
