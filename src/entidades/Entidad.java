package entidades;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Entidad {
	// Atributos de instancia
	protected EntidadGrafica entidadGrafica;
	protected Movimiento movimiento;
	protected int velocidad;

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
	}

	// Metodos
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
	
	public int getMovimiento() {
		return velocidad;
	}
}
