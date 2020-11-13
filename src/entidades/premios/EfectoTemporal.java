package entidades.premios;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class EfectoTemporal extends Premio {	

	// Atributos de instancia
	int duracion;
	// Constructor
	public EfectoTemporal(EntidadGrafica eg, Movimiento m, int v, int d) {
		super(eg, m, v);
		duracion = d;
	}

}
