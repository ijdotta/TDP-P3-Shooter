package factories.infectados;

import entidades.Entidad;
import entidades.infectados.Alpha;
import factories.EntidadFactory;
import logica.Juego;

public class InfectadoAlphaFactory extends EntidadFactory {

	public InfectadoAlphaFactory(Juego j) {
		super(j);
	}

	@Override
	public Entidad crearEntidad() {
		return new Alpha(juego);
	}

}
