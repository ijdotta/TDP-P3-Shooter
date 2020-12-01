package logica.factories.premios;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.premios.EfectoPocion;
import logica.factories.EntidadFactory;

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
