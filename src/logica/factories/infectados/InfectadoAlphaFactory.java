package logica.factories.infectados;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.infectados.Alpha;
import logica.factories.EntidadFactory;

public class InfectadoAlphaFactory extends EntidadFactory {

	public InfectadoAlphaFactory(Juego j) {
		super(j);
	}

	@Override
	public Entidad crearEntidad() {
		return new Alpha(juego);
	}

}
