package factories.premios;

import entidades.Entidad;
import entidades.premios.EfectoCuarentena;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.premios.GraficoCuarentena;
import factories.EntidadFactory;
import movimientos.MVertical;
import movimientos.Movimiento;

public class PremioTemporalCuarentenaFactory extends EntidadFactory {

	@Override
	public Entidad crearEntidad() {
		Movimiento m = new MVertical(null, MVertical.DOWN);
		EntidadGrafica eg = new GraficoCuarentena();
		
		Entidad nueva_cuarentena = new EfectoCuarentena(eg, m, 1, 9);
		m.setEntidad(nueva_cuarentena);
		
		return nueva_cuarentena;
	}

}
