package entidades.proyectiles;

import entidadesGraficas.proyectiles.GraficoProyectilFuerte;
import logica.Juego;
import visitors.Visitor;

public class Proyectil_Fuerte extends Proyectil_Jugador{

	public Proyectil_Fuerte(Juego j) {
		super(j);
		entidadGrafica = new GraficoProyectilFuerte(4, 25);
		velocidad = 13;
		damage = 34;
	}

	@Override
	public void accept(Visitor v) {
		v.visitProjectilJ(this);		
	}

}
