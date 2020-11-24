package factories.premios;

import entidades.Entidad;
import entidades.premios.EfectoPocion;
import factories.EntidadFactory;
import logica.Juego;

public class PremioPermanentePocionFactory extends EntidadFactory {

	public PremioPermanentePocionFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		return new EfectoPocion(juego);
	}

}
