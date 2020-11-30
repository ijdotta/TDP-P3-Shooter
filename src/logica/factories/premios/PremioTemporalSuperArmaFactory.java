package logica.factories.premios;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.premios.EfectoSuperArma;
import logica.factories.EntidadFactory;

public class PremioTemporalSuperArmaFactory extends EntidadFactory {

	public PremioTemporalSuperArmaFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		return new EfectoSuperArma(juego);
	}

}
