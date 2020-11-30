package logica.entidades.proyectiles;

import logica.Juego;
import logica.entidadesGraficas.proyectiles.GraficoProyectilJugador;
import logica.movimientos.MVertical;
import logica.visitors.Visitor;
import logica.visitors.proyectiles.VisitorProyectilJ;

public class Proyectil_Jugador extends Proyectil {

	public Proyectil_Jugador(Juego j) {
		super(j);
		movimiento = new MVertical(this, MVertical.UP);
		entidadGrafica = new GraficoProyectilJugador(4, 30);
		visitor = new VisitorProyectilJ(this);
		velocidad = 15;
		damage = 25;
	}

	@Override
	public void accept(Visitor v) {
		v.visitProjectilJ(this);
	}

}
