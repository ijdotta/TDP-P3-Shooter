package factories.premios;

import entidades.Entidad;
import entidades.premios.EfectoSuperArma;
import factories.EntidadFactory;
import logica.Juego;

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
