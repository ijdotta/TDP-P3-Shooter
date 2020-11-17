package entidades.premios;

import entidadesGraficas.EntidadGrafica;
import logica.Juego;
import movimientos.Movimiento;
import visitors.Visitor;

public class EfectoPocion extends EfectoPermanente {

	public EfectoPocion(Juego j, EntidadGrafica eg, Movimiento m, int v) {
		super(j, eg, m, v);
	}

	@Override
	public void accept(Visitor v) {
		v.visitPocion(this);
	}

}
