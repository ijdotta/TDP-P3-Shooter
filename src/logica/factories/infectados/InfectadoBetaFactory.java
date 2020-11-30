package logica.factories.infectados;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.infectados.Beta;
import logica.factories.EntidadFactory;

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
