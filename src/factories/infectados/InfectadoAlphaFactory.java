package factories.infectados;

import entidades.Entidad;
import entidades.infectados.Alpha;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.infectados.GraficoAlpha;
import factories.EntidadFactory;
import logica.Juego;
import movimientos.MVertical;
import movimientos.Movimiento;
import visitors.infectados.VisitorAlpha;

public class InfectadoAlphaFactory extends EntidadFactory {

	public InfectadoAlphaFactory(Juego j) {
		super(j);
	}

	@Override
	public Entidad crearEntidad() {
		return new Alpha(juego);
	}

}
