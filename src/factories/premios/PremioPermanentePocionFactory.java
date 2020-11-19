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
		Movimiento m = new MVertical(null, MVertical.DOWN);
		EntidadGrafica eg = new GraficoPocion(30, 30);

		Entidad nueva_pocion = new EfectoPocion(juego, eg, m, 5);
		m.setEntidad(nueva_pocion);

		return nueva_pocion;
	}

}
