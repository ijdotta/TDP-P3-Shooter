package entidades;

import javax.swing.JLabel;

import entidades.estados.DefaultState;
import entidades.estados.State;
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
	protected State state;

	// Constructor
	/**
	 * Inicia la entidad con 100 de vida.
	 * 
	 * @param v  Movimiento que se va a utilizar
	 * @param eg Velocidad
	 * @param m  Entidad Grafica
	 */
	public Entidad(Juego j) {
		juego = j;

		visitor = new VisitorNulo();
		vida = 100;
		state = new DefaultState(this);
	}

	// Metodos
	public abstract void accept(Visitor v);

	/**
	 * Redefinir disparo a aquellas entidades que disparen.
	 */
	public void disparar() {
		state.disparar();
	}

	/**
	 * Redefinir morir a aquellas entidades que hagan alguna accion al morir.
	 */
	public void morir() {
		state.morir();
	}

	public void mover() {
		state.mover();
	}

	public void outOfBounds() {
		if (this.checkOutOfBounds()) {
			vida = -1;
		}
	}

	/**
	 * Indica si la Entidad actual esta fuera del escenario.
	 * 
	 * @return True si esta fuera del escenario, False caso contrario.
	 */
	protected boolean checkOutOfBounds() {
		boolean dentro_x, dentro_y;
		int entidad_x, entidad_y, entidad_w, entidad_h, frame_w, frame_h;

		JLabel lblE = entidadGrafica.getLabelImagen();
		entidad_x = lblE.getX();
		entidad_y = lblE.getY();

		entidad_w = lblE.getWidth();
		entidad_h = lblE.getHeight();

		frame_w = juego.escenarioWidth();
		frame_h = juego.escenarioHeight();

		dentro_x = ((entidad_x + entidad_w) >= 0) && (entidad_x <= frame_w);
		dentro_y = ((entidad_y + entidad_h) >= 0) && (entidad_y <= frame_h);
		
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

	public State getState() {
		return state;
	}

	public void setState(State s) {
		state = s;
	}
	
	/**
	 * Retorna el JLabel de la entidad grafica.
	 * @return JLabel de la entidad grafica.
	 */
	public JLabel getLabelImagen() {
		return entidadGrafica.getLabelImagen();
	}
	
	/**
	 * Retorna el ancho del label.
	 * @return ancho del label.
	 */
	public int getWidth() {
		return entidadGrafica.getWidth();
	}
	
	/**
	 * Retorna la altura del label
	 * @return altura del label
	 */
	public int getHeight() {
		return entidadGrafica.getHeight();
	}
	
	/**
	 * setea el ancho y alto del label
	 * @param w ancho
	 * @param h alto
	 */
	public void setSize(int w, int h) {
		entidadGrafica.setSize(w, h);
	}
	/**
	 * Retorna la posicion del label en el eje x
	 * @return posicion del label en el eje x
	 */
	public int getX() {
		return entidadGrafica.getX();
	}
	
	/**
	 * Retorna la posicion del label en el eje y
	 * @return posicion del label en el eje y
	 */
	public int getY() {
		return entidadGrafica.getY();
	}
	/**
	 * Setea la posicion del label segun los ejes coordenados
	 * @param x posicion del label en el eje x
	 * @param y posicion del label en el eje y
	 */
	public void setLocation(int x, int y) {
		entidadGrafica.setLocation(x, y);
	}
}
