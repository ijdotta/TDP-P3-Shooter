package factories.infectados;

import entidades.Entidad;
import entidades.infectados.Beta;
import factories.EntidadFactory;
import logica.Juego;

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
