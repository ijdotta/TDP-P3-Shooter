package factories.premios;

import entidades.Entidad;
import entidades.premios.EfectoSuperArma;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.premios.GraficoSuperArma;
import factories.EntidadFactory;
import movimientos.MVertical;
import movimientos.Movimiento;

public class PremioTemporalSuperArmaFactory extends EntidadFactory {

	@Override
	public Entidad crearEntidad() {
		Movimiento m = new MVertical(null, MVertical.DOWN);
		EntidadGrafica eg = new GraficoSuperArma(25,25);
		
		Entidad nueva_super_arma = new EfectoSuperArma(eg, m, 1, 19);
		m.setEntidad(nueva_super_arma);
		
		return nueva_super_arma;
	}

}
