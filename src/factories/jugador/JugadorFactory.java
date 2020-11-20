package factories.jugador;

import entidades.Entidad;
import entidades.jugador.Jugador;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.jugador.GraficoJugador;
import factories.EntidadFactory;
import logica.Juego;
import movimientos.MHorizontal;
import movimientos.Movimiento;
import visitors.jugador.VisitorJugador;

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
