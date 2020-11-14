package entidades.infectados;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;
import visitors.Visitor;

public class Alpha extends Infectado {

	public Alpha(EntidadGrafica eg, Movimiento m, int v, int dmg) {
		super(eg, m, v, dmg);
	}

	@Override
	public void accept(Visitor v) {
		v.visitAlpha(this);
	}


}
