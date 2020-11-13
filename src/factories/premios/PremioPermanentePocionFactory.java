package factories.premios;

import entidades.Entidad;
import entidades.premios.EfectoPocion;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.premios.GraficoPocion;
import factories.EntidadFactory;
import movimientos.MVertical;
import movimientos.Movimiento;

public class PremioPermanentePocionFactory extends EntidadFactory {

	@Override
	public Entidad crearEntidad() {
		Movimiento m = new MVertical(null, MVertical.DOWN);
		EntidadGrafica eg = new GraficoPocion();
		
		Entidad nueva_pocion = new EfectoPocion(eg, m, 1);
		m.setEntidad(nueva_pocion);
		
		return nueva_pocion;
	}

}
