package factories.infectados;

import entidades.Entidad;
import entidades.infectados.Alpha;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.infectados.GraficoAlpha;
import factories.EntidadFactory;
import movimientos.MVertical;
import movimientos.Movimiento;
import visitors.infectados.VisitorAlpha;

public class InfectadoAlphaFactory extends EntidadFactory {

	@Override
	public Entidad crearEntidad() {
		Movimiento m = new MVertical(null, MVertical.DOWN);
		EntidadGrafica eg = new GraficoAlpha(50,50);
		
		Entidad nuevo_alpha = new Alpha(eg, m, 1, 10);
		m.setEntidad(nuevo_alpha);
		nuevo_alpha.setVisitor(new VisitorAlpha((Alpha) nuevo_alpha));
		
		return nuevo_alpha;
	}

}
