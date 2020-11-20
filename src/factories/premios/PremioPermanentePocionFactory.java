package factories.premios;

import entidades.Entidad;
import entidades.premios.EfectoPocion;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.premios.GraficoPocion;
import factories.EntidadFactory;
import logica.Juego;
import movimientos.MVertical;
import movimientos.Movimiento;

public class PremioPermanentePocionFactory extends EntidadFactory {

	public PremioPermanentePocionFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		return new EfectoPocion(juego);
	}

}
