package entidades.premios;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;
import visitors.Visitor;

public class EfectoPocion extends EfectoPermanente{

	public EfectoPocion(EntidadGrafica eg, Movimiento m, int v) {
		super(eg, m, v);
	}

	@Override
	public void accept(Visitor v) {
		v.visitPocion(this);
	}


}
