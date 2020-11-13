package entidades.premios;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class EfectoTemporal extends Premio {	

	// Atributos de instancia
	int duracion;
	// Constructor
	public EfectoTemporal(Movimiento m, int v, EntidadGrafica eg, int d) {
		super(m, v, eg);
		duracion = d;
	}
}
