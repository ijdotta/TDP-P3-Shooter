package entidades.proyectiles;

import logica.Juego;
import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;
import visitors.Visitor;

public class Proyectil_Jugador extends Proyectil {

	public Proyectil_Jugador(Juego j, EntidadGrafica eg, Movimiento m, int v, int dmg) {
		super(j, eg, m, v, dmg);
	}

	@Override
	public void accept(Visitor v) {
		v.visitProjectilJ(this);
	}

}
