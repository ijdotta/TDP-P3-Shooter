package entidades.jugador;

import entidades.Personaje;
import entidadesGraficas.jugador.GraficoJugador;
import factories.proyectiles.ProyectilJugadorFactory;
import logica.Juego;
import movimientos.MHorizontal;
import visitors.Visitor;
import visitors.jugador.VisitorJugador;

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
}
