package logica.entidades.jugador;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.Personaje;
import logica.entidadesGraficas.jugador.GraficoJugador;
import logica.factories.proyectiles.ProyectilJugadorFactory;
import logica.movimientos.MHorizontal;
import logica.visitors.Visitor;
import logica.visitors.jugador.VisitorJugador;

/**
 * Class Jugador Implementacion de un jugador.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class Jugador extends Personaje {
	// Constructor
	/**
	 * Inicia el jugador con su movimiento horizontal, su sprite grafico, 9 de
	 * velocidad, su visitor, y su fabrica de proyectiles de jugador.
	 * 
	 * @param j juego a conocer
	 */
	public Jugador(Juego j) {
		super(j);

		movimiento = new MHorizontal(this, MHorizontal.LEFT);

		entidadGrafica = new GraficoJugador();

		velocidad = 9;

		visitor = new VisitorJugador(this);

		proyectil = new ProyectilJugadorFactory(juego);
	}
	// Metodos

	@Override
	public void accept(Visitor v) {
		v.visitJugador(this);
	}

	/**
	 * Settea la vida actual con la que es pasada por parametro, luego pide al juego
	 * actualizar en el display la vida actual.
	 * 
	 * @param val vida nueva
	 */
	public void setVida(int val) {
		super.setVida(val);
		this.actualizarVidaJugador();
	}

	/**
	 * Recibe daño de una entidad, luego pide al juego actualizar en el display la
	 * vida actual.
	 * 
	 * @param enemy Enemigo que provoca el daño.
	 */
	public void damage(Entidad enemy) {
		super.damage(enemy);
		this.actualizarVidaJugador();
	}

	/**
	 * Le pide al juego actualizar en el display la vida actual.
	 */
	private void actualizarVidaJugador() {
		juego.actualizarVidaJugador(vida);
	}
}
