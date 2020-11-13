package factories.infectados;

import entidades.Entidad;
import entidades.infectados.Beta;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.infectados.GraficoBeta;
import factories.EntidadFactory;
import movimientos.MVertical;
import movimientos.Movimiento;

public class InfectadoBetaFactory extends EntidadFactory {

	@Override
	public Entidad crearEntidad() {
		Movimiento m = new MVertical(null, MVertical.DOWN);
		EntidadGrafica eg = new GraficoBeta();
		
		Entidad nuevo_beta = new Beta(eg, m, 1, 20);
		m.setEntidad(nuevo_beta);
		
		return nuevo_beta;
	}

}
