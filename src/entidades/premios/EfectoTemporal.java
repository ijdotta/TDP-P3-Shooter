package entidades.premios;

import entidadesGraficas.EntidadGrafica;
import logica.Juego;
import movimientos.Movimiento;

public abstract class EfectoTemporal extends Premio {

	// Atributos de instancia
	int duracion;

	// Constructor
	public EfectoTemporal(Juego j, EntidadGrafica eg, Movimiento m, int v, int d) {
		super(j, eg, m, v);
		duracion = d;
	}

}
