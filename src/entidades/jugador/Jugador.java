package entidades.jugador;

import entidades.Personaje;
import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;
import visitors.Visitor;

public class Jugador extends Personaje{
	// Atributos de instancia
	// Constructor
	public Jugador(EntidadGrafica eg, Movimiento m, int v) {
		super(eg, m, v);
	}
	// Metodos

	@Override
	public void accept(Visitor v) {
		v.visitJugador(this);
	}
}
