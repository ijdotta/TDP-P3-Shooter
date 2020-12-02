package logica.entidades.jugador;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.Personaje;
import logica.entidadesGraficas.jugador.GraficoJugador;
import logica.factories.proyectiles.ProyectilJugadorFactory;
import logica.movimientos.MHorizontal;
import logica.visitors.Visitor;
import logica.visitors.jugador.VisitorJugador;

public class Jugador extends Personaje {
	// Atributos de instancia
	// Constructor
	public Jugador(Juego j) {
		super(j);

		movimiento = new MHorizontal(this, MHorizontal.LEFT);

		entidadGrafica = new GraficoJugador(50, 50);

		velocidad = 9;

		visitor = new VisitorJugador(this);

		proyectil = new ProyectilJugadorFactory(juego);
	}
	// Metodos

	@Override
	public void accept(Visitor v) {
		v.visitJugador(this);
	}

	public void setVida(int val) {
		super.setVida(val);
		this.actualizarVidaJugador();		
	}
	
	public void damage(Entidad enemy) {
		super.damage(enemy);
		this.actualizarVidaJugador();
	}
	
	private void actualizarVidaJugador() {
		juego.actualizarVidaJugador(vida);
	}
}
