package entidades.infectados;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;
import visitors.Visitor;

public class Beta extends Infectado {

	public Beta(EntidadGrafica eg, Movimiento m, int v, int dmg) {
		super(eg, m, v, dmg);
	}

	@Override
	public void accept(Visitor v) {
		System.out.println("aaa");
		v.visitBeta(this);		
	}



}
