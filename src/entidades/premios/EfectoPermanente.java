package entidades.premios;

import entidadesGraficas.EntidadGrafica;
import logica.Juego;
import movimientos.Movimiento;

public abstract class EfectoPermanente extends Premio {

	public EfectoPermanente(Juego j, EntidadGrafica eg, Movimiento m, int v) {
		super(j, eg, m, v);
	}

}
