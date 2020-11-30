package logica.entidades.infectados;

import logica.Juego;
import logica.entidadesGraficas.infectados.GraficoBeta;
import logica.visitors.Visitor;
import logica.visitors.infectados.VisitorBeta;

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
