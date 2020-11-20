package factories.proyectiles;

import entidades.Entidad;
import entidades.proyectiles.Proyectil_Jugador;
import factories.EntidadFactory;
import logica.Juego;

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
