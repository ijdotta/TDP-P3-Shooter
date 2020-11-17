package factories.jugador;

import entidades.Entidad;
import entidades.jugador.Jugador;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.jugador.GraficoJugador;
import factories.EntidadFactory;
import logica.Juego;
import movimientos.MHorizontal;
import movimientos.Movimiento;

public class JugadorFactory extends EntidadFactory {

	public JugadorFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		Movimiento m = new MHorizontal(null, MHorizontal.LEFT);
		EntidadGrafica eg = new GraficoJugador(50, 50);

		Entidad nuevo_jugador = new Jugador(juego, eg, m, 9);
		m.setEntidad(nuevo_jugador);

		return nuevo_jugador;
	}

}
