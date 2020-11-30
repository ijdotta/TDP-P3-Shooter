package logica.factories.proyectiles;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.proyectiles.Proyectil_Jugador;
import logica.factories.EntidadFactory;

public class ProyectilJugadorFactory extends EntidadFactory {

	public ProyectilJugadorFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		return new Proyectil_Jugador(juego);
	}

}
