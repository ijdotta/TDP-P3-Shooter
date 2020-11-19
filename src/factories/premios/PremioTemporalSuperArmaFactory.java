package factories.premios;

import entidades.Entidad;
import entidades.premios.EfectoSuperArma;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.premios.GraficoSuperArma;
import factories.EntidadFactory;
import logica.Juego;
import movimientos.MVertical;
import movimientos.Movimiento;

public class PremioTemporalSuperArmaFactory extends EntidadFactory {

	public PremioTemporalSuperArmaFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		Movimiento m = new MVertical(null, MVertical.DOWN);
		EntidadGrafica eg = new GraficoSuperArma(30, 30);

		Entidad nueva_super_arma = new EfectoSuperArma(juego, eg, m, 5, 19);
		m.setEntidad(nueva_super_arma);

		return nueva_super_arma;
	}

}
