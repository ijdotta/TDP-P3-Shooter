package entidades;

import entidadesGraficas.EntidadGrafica;
import logica.Juego;
import movimientos.Movimiento;
import visitors.Visitor;
import visitors.VisitorNulo;

public abstract class Entidad {
	// Atributos de instancia
	protected Juego juego;
	protected EntidadGrafica entidadGrafica;
	protected Movimiento movimiento;
	protected int velocidad;
	protected Visitor visitor;
	protected int vida;

	// Constructor
	/**
	 * Inicia la entidad con 100 de vida.
	 * 
	 * @param v  Movimiento que se va a utilizar
	 * @param eg Velocidad
	 * @param m  Entidad Grafica
	 */
	public Entidad(Juego j, EntidadGrafica eg, Movimiento m, int v) {
		juego = j;
		entidadGrafica = eg;
		movimiento = m;
		velocidad = v;
		visitor = new VisitorNulo();
		vida = 100;
	}

	// Metodos
	public abstract void accept(Visitor v);
	
	/**
	 * Implementar disparo a aquellas entidades que disparen.
	 */
	public void disparar() {}
	
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

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor v) {
		visitor = v;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int val) {
		vida = val;
	}
}
