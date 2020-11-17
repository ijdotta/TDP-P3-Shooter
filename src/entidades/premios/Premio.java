package entidades.premios;

import entidades.Entidad;
import logica.Juego;
import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Premio extends Entidad {

	public Premio(Juego j, EntidadGrafica eg, Movimiento m, int v) {
		super(j, eg, m, v);
	}

}
