package entidades.premios;

import entidades.Entidad;
import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Premio extends Entidad {

	public Premio(EntidadGrafica eg, Movimiento m, int v) {
		super(eg, m, v);
	}

}
