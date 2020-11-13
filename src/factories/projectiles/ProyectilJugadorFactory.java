package factories.projectiles;

import entidades.Entidad;
import entidades.premios.EfectoSuperArma;
import entidades.projectiles.Projectil_Jugador;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.projectiles.GraficoProjectilJugador;
import factories.EntidadFactory;
import movimientos.MVertical;
import movimientos.Movimiento;

public class ProyectilJugadorFactory extends EntidadFactory {

	@Override
	public Entidad crearEntidad() {
		Movimiento m = new MVertical(null, MVertical.UP);
		EntidadGrafica eg = new GraficoProjectilJugador();
		
		Entidad nuevo_pJugador = new Projectil_Jugador(eg, m, 6, 25);
		m.setEntidad(nuevo_pJugador);
		
		return nuevo_pJugador;
	}

}
