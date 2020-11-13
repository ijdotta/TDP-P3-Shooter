package entidades.premios;

import entidades.Entidad;
import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Premio extends Entidad {

	public Premio(Movimiento m, int v, EntidadGrafica eg) {
		super(m, v, eg);
	}

}
