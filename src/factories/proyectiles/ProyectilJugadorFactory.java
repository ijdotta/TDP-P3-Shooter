package factories.proyectiles;

import entidades.Entidad;
import entidades.proyectiles.Proyectil_Jugador;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.proyectiles.GraficoProyectilJugador;
import factories.EntidadFactory;
import logica.Juego;
import movimientos.MVertical;
import movimientos.Movimiento;
import visitors.proyectiles.VisitorProyectilJ;

public class ProyectilJugadorFactory extends EntidadFactory {

	public ProyectilJugadorFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		Movimiento m = new MVertical(null, MVertical.UP);
		EntidadGrafica eg = new GraficoProyectilJugador(3, 30);

		Entidad nuevo_pJugador = new Proyectil_Jugador(juego, eg, m, 15, 25);
		m.setEntidad(nuevo_pJugador);
		nuevo_pJugador.setVisitor(new VisitorProyectilJ((Proyectil_Jugador) nuevo_pJugador));

		return nuevo_pJugador;
	}

}
