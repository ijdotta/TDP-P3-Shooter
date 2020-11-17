package entidades.premios;

import entidadesGraficas.EntidadGrafica;
import logica.Juego;
import movimientos.Movimiento;
import visitors.Visitor;

public class EfectoSuperArma extends EfectoTemporal {

	public EfectoSuperArma(Juego j, EntidadGrafica eg, Movimiento m, int v, int d) {
		super(j, eg, m, v, d);
	}

	@Override
	public void accept(Visitor v) {
		v.visitSuperArma(this);
	}
}
