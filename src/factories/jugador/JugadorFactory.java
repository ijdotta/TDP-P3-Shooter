package factories.jugador;

import entidades.Entidad;
import entidades.jugador.Jugador;
import factories.EntidadFactory;
import logica.Juego;

public class JugadorFactory extends EntidadFactory {

	public JugadorFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		return new Jugador(juego);
	}

}
