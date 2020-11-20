package factories.premios;

import entidades.Entidad;
import entidades.premios.EfectoCuarentena;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.premios.GraficoCuarentena;
import factories.EntidadFactory;
import logica.Juego;
import movimientos.MVertical;
import movimientos.Movimiento;

public class PremioTemporalCuarentenaFactory extends EntidadFactory {

	public PremioTemporalCuarentenaFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		return new EfectoCuarentena(juego);
	}

}
