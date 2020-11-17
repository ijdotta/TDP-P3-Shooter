package entidades.jugador;

import entidades.Personaje;
import entidadesGraficas.EntidadGrafica;
import factories.proyectiles.ProyectilJugadorFactory;
import logica.Juego;
import movimientos.Movimiento;
import visitors.Visitor;

public class Jugador extends Personaje {
	// Atributos de instancia
	// Constructor
	public Jugador(Juego j, EntidadGrafica eg, Movimiento m, int v) {
		super(j, eg, m, v);
		proyectil = new ProyectilJugadorFactory(juego);
	}
	// Metodos

	@Override
	public void accept(Visitor v) {
		v.visitJugador(this);
	}
}
