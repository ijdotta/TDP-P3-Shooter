package entidades.infectados;

import entidadesGraficas.infectados.GraficoBeta;
import logica.Juego;
import visitors.Visitor;
import visitors.infectados.VisitorBeta;

public class Beta extends Infectado {

	public Beta(Juego j) {
		super(j);

		entidadGrafica = new GraficoBeta(50, 50);
		damage = 2;
		visitor = new VisitorBeta(this);
	}

	@Override
	public void accept(Visitor v) {
		v.visitBeta(this);
	}

}
