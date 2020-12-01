package logica.factories.premios;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.premios.EfectoCuarentena;
import logica.factories.EntidadFactory;

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
