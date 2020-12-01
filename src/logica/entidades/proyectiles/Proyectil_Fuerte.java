package logica.entidades.proyectiles;

import logica.Juego;
import logica.entidadesGraficas.proyectiles.GraficoProyectilFuerte;
import logica.visitors.Visitor;

public class Proyectil_Fuerte extends Proyectil_Jugador {

	public Proyectil_Fuerte(Juego j) {
		super(j);
		entidadGrafica = new GraficoProyectilFuerte(6, 24);
		velocidad = 13;
		damage = 34;
	}

	@Override
	public void accept(Visitor v) {
		v.visitProjectilJ(this);
	}

}
