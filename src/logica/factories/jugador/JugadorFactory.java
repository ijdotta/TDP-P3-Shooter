package logica.factories.jugador;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.jugador.Jugador;
import logica.factories.EntidadFactory;

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
