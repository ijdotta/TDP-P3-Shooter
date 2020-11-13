package entidades.premios;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class EfectoPermanente extends Premio {

	public EfectoPermanente(EntidadGrafica eg, Movimiento m, int v) {
		super(eg, m, v);
	}

}
