package entidades.proyectiles;

import logica.Juego;
import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;
import visitors.Visitor;

public class Proyectil_Infectado extends Proyectil {

	public Proyectil_Infectado(Juego j, EntidadGrafica eg, Movimiento m, int v, int dmg) {
		super(j, eg, m, v, dmg);
	}

	@Override
	public void accept(Visitor v) {
		v.visitProjectilI(this);
	}
}
