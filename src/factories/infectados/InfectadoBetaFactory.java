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
		return new Beta(juego);
	}

}
