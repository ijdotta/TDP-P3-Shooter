package entidades.proyectiles;

import entidadesGraficas.proyectiles.GraficoProyectilJugador;
import logica.Juego;
import movimientos.MVertical;
import visitors.Visitor;
import visitors.proyectiles.VisitorProyectilJ;

public class Proyectil_Jugador extends Proyectil {

	public Proyectil_Jugador(Juego j) {
		super(j);
		movimiento = new MVertical(this, MVertical.UP);
		entidadGrafica = new GraficoProyectilJugador(3, 30);
		visitor = new VisitorProyectilJ(this);
		velocidad = 15;
		damage = 25;
	}

	@Override
	public void accept(Visitor v) {
		v.visitProjectilJ(this);
	}

}
