package entidades.premios;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;
import visitors.Visitor;

public class EfectoCuarentena extends EfectoTemporal {

	public EfectoCuarentena(EntidadGrafica eg, Movimiento m, int v, int d) {
		super(eg, m, v, d);
	}

	@Override
	public void accept(Visitor v) {
		v.visitCuarentena(this);
	}

}
