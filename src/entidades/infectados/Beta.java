package entidades.infectados;

import entidadesGraficas.EntidadGrafica;
import logica.Juego;
import movimientos.Movimiento;
import visitors.Visitor;

public class Beta extends Infectado {

	public Beta(Juego j, EntidadGrafica eg, Movimiento m, int v, int dmg) {
		super(j, eg, m, v, dmg);
	}

	@Override
	public void accept(Visitor v) {
		System.out.println("aaa");
		v.visitBeta(this);
	}

}
