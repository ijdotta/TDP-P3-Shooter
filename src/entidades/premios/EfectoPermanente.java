package entidades.premios;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class EfectoPermanente extends Premio {

	public EfectoPermanente(Movimiento m, int v, EntidadGrafica eg) {
		super(m, v, eg);
	}

}
