package logica.entidades;

import javax.swing.JLabel;

import logica.Juego;
import logica.entidades.estados.DefaultState;
import logica.entidades.estados.State;
import logica.entidadesGraficas.EntidadGrafica;
import logica.movimientos.Movimiento;
import logica.visitors.Visitor;

/**
 * Abstract Class Entidad Implementacion y definicion de los comportamientos
 * generales de una entidad.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public abstract class Entidad {
	// Atributos de instancia
	protected static int VIDA_MAX = 100;
	protected Juego juego;
	protected EntidadGrafica entidadGrafica;
	protected Movimiento movimiento;
	protected int velocidad;
	protected Visitor visitor;
	protected int vida;
	protected State state;
	protected int damage;

	// Constructor
	/**
	 * Inicia la entidad con 100 de vida, un visitor nulo, y un state por defecto.
	 * 
	 * @param j juego a conocer
	 */
	public Entidad(Juego j) {
		juego = j;
		vida = Entidad.VIDA_MAX;
		state = new DefaultState(this);
	}

	// Metodos
	/**
	 * Cada entidad concreta se reporta en el visitor pasado por parametro.
	 * 
	 * @param v visitor
	 */
	public abstract void accept(Visitor v);

	/**
	 * Disparar segun el comportamiento de su state.
	 */
	public void disparar() {
		state.disparar();
	}

	/**
	 * Morir segun el comportamiento de su state.
	 */
	public void morir() {
		state.morir();
	}

	/**
	 * Moverse segun el comportamiento de su state.
	 */
	public void mover() {
		state.mover();
	}

	/**
	 * Recibe daño de una entidad.
	 * 
	 * @param enemy Enemigo que provoca el daño.
	 */
	public void damage(Entidad enemy) {
		this.vida -= enemy.getDamage();
	}
	
	/**
	 * Si la entidad esta fuera del escenario procede a morir.
	 */
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
	/**
	 * Hace que la entidad muera.
	 */
	public void destruir() {
		this.vida = -1;
	}

	// Setters/Getters
	/**
	 * retorna el daño que provoca la entidad
	 * 
	 * @return daño que provoca la entidad
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * Settea el daño actual con el que es pasado por parametro.
	 * 
	 * @param dmg daño nuevo
	 */
	public void setDamage(int dmg) {
		damage = dmg;
	}
	/**
	 * Settea la entidad grafica actual con la que es pasada por parametro.
	 * 
	 * @param eg entidad grafica nueva
	 */
	public void setEntidadGrafica(EntidadGrafica eg) {
		entidadGrafica = eg;
	}

	/**
	 * Settea el movimiento actual con el que es pasado por parametro.
	 * 
	 * @param m movimiento nuevo
	 */
	public void setMovimiento(Movimiento m) {
		movimiento = m;
	}

	/**
	 * Settea la velocidad actual con la que es pasada por parametro.
	 * 
	 * @param v velocidad nueva
	 */
	public void setVelocidad(int v) {
		velocidad = v;
	}

	/**
	 * Retorna la velocidad actual
	 * 
	 * @return velocidad actual
	 */
	public int getVelocidad() {
		return velocidad;
	}

	/**
	 * Retorna la entidad grafica actual
	 * 
	 * @return entidad grafica actual
	 */
	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}

	/**
	 * Retorna el movimiento actual
	 * 
	 * @return movimiento actual
	 */
	public Movimiento getMovimiento() {
		return movimiento;
	}

	/**
	 * Retorna el visitor actual
	 * 
	 * @return visitor actual
	 */
	public Visitor getVisitor() {
		return visitor;
	}

	/**
	 * Settea el visitor actual con el que es pasado por parametro.
	 * 
	 * @param v visitor nuevo
	 */
	public void setVisitor(Visitor v) {
		visitor = v;
	}

	/**
	 * Retorna la vida actual
	 * 
	 * @return vida actual
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * Settea la vida actual con la que es pasada por parametro.
	 * 
	 * @param val vida nueva
	 */
	public void setVida(int val) {
		vida = val;
	}

	/**
	 * Retorna el juego actual
	 * 
	 * @return juego actual
	 */
	public Juego getJuego() {
		return juego;
	}

	/**
	 * Settea el juego actual con el que es pasado por parametro.
	 * 
	 * @param j juego nuevo
	 */
	public void setJuego(Juego j) {
		juego = j;
	}

	/**
	 * Retorna el state actual
	 * 
	 * @return state actual
	 */
	public State getState() {
		return state;
	}

	/**
	 * Settea el state actual con el que es pasado por parametro.
	 * 
	 * @param s state nuevo
	 */
	public void setState(State s) {
		state = s;
	}

	/**
	 * Retorna el JLabel de la entidad grafica.
	 * 
	 * @return JLabel de la entidad grafica.
	 */
	public JLabel getLabelImagen() {
		return entidadGrafica.getLabelImagen();
	}

	/**
	 * Retorna el ancho del label.
	 * 
	 * @return ancho del label.
	 */
	public int getWidth() {
		return entidadGrafica.getWidth();
	}

	/**
	 * Retorna la altura del label
	 * 
	 * @return altura del label
	 */
	public int getHeight() {
		return entidadGrafica.getHeight();
	}

	/**
	 * setea el ancho y alto del label
	 * 
	 * @param w ancho
	 * @param h alto
	 */
	public void setSize(int w, int h) {
		entidadGrafica.setSize(w, h);
	}

	/**
	 * Retorna la posicion del label en el eje x
	 * 
	 * @return posicion del label en el eje x
	 */
	public int getX() {
		return entidadGrafica.getX();
	}

	/**
	 * Retorna la posicion del label en el eje y
	 * 
	 * @return posicion del label en el eje y
	 */
	public int getY() {
		return entidadGrafica.getY();
	}

	/**
	 * Setea la posicion del label segun los ejes coordenados
	 * 
	 * @param x posicion del label en el eje x
	 * @param y posicion del label en el eje y
	 */
	public void setLocation(int x, int y) {
		entidadGrafica.setLocation(x, y);
	}
}
