package factories.jugador;

import entidades.Entidad;
import entidades.jugador.Jugador;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.jugador.GraficoJugador;
import factories.EntidadFactory;
import movimientos.MHorizontal;
import movimientos.Movimiento;

public class JugadorFactory extends EntidadFactory {

	@Override
	public Entidad crearEntidad() {
		Movimiento m = new MHorizontal(null, MHorizontal.LEFT);
		EntidadGrafica eg = new GraficoJugador(50,50);
		
		Entidad nuevo_jugador = new Jugador(eg, m, 9);
		m.setEntidad(nuevo_jugador);
		
		return nuevo_jugador;
	}

}
