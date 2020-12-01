package logica.entidades.proyectiles;

import logica.Juego;
import logica.entidadesGraficas.proyectiles.GraficoProyectilInfectado;
import logica.movimientos.MVertical;
import logica.visitors.Visitor;
import logica.visitors.proyectiles.VisitorProyectilI;

public class Proyectil_Infectado extends Proyectil {

	public Proyectil_Infectado(Juego j) {
		super(j);

		movimiento = new MVertical(this, MVertical.DOWN);
		entidadGrafica = new GraficoProyectilInfectado(10, 10);
		visitor = new VisitorProyectilI(this);
		velocidad = 10;
		damage = 15;
	}

	@Override
	public void accept(Visitor v) {
		v.visitProjectilI(this);
	}
}
