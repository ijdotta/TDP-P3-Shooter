package logica.entidades.infectados;

import logica.Juego;
import logica.entidadesGraficas.infectados.GraficoAlpha;
import logica.visitors.Visitor;
import logica.visitors.infectados.VisitorAlpha;

public class Alpha extends Infectado {

	public Alpha(Juego j) {
		super(j);
		
		damage = 1;
		entidadGrafica = new GraficoAlpha(50, 50);
		visitor = new VisitorAlpha(this);
	}

	@Override
	public void accept(Visitor v) {
		v.visitAlpha(this);
	}

}
