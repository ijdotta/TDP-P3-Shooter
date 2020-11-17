package factories.infectados;

import entidades.Entidad;
import entidades.infectados.Beta;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.infectados.GraficoBeta;
import factories.EntidadFactory;
import logica.Juego;
import movimientos.MVertical;
import movimientos.Movimiento;

public class InfectadoBetaFactory extends EntidadFactory {

	public InfectadoBetaFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		Movimiento m = new MVertical(null, MVertical.DOWN);
		EntidadGrafica eg = new GraficoBeta(50, 50);

		Entidad nuevo_beta = new Beta(juego, eg, m, 1, 20);
		m.setEntidad(nuevo_beta);

		return nuevo_beta;
	}

}
