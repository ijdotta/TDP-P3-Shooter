package entidades;

import javax.swing.JLabel;

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
	public void disparar() {
	}

	public void outOfBounds() {
		if (this.checkOutOfBounds()) {
			vida = -1;
		}
	}

	/**
	 * Indica si la Entidad actual esta fuera del escenario.
	 * @return True si esta fuera del escenario, False caso contrario.
	 */
	protected boolean checkOutOfBounds() {
		boolean dentro_x, dentro_y;
		int entidad_x, entidad_y, frame_w, frame_h;

		JLabel lblE = entidadGrafica.getLabelImagen();
		entidad_x = lblE.getX();
		entidad_y = lblE.getY();

		frame_w = juego.getGui().getWidth();
		frame_h = juego.getGui().getHeight();

		dentro_x = (entidad_x >= 0) && (entidad_x <= frame_w);
		dentro_y = (entidad_y >= 0) && (entidad_y <= frame_h);

		return !(dentro_x && dentro_y);
	}

	// Setters/Getters
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
	
	public Juego getJuego() {
		return juego;
	}
	
	public void setJuego(Juego j) {
		juego = j;
	}
}
