package entidades.premios;

import entidadesGraficas.premios.GraficoPocion;
import logica.Juego;
import visitors.Visitor;

public class EfectoPocion extends EfectoPermanente {

	public EfectoPocion(Juego j) {
		super(j);
		
		velocidad = 5;
		entidadGrafica = new GraficoPocion(30, 30);
	}

	@Override
	public void accept(Visitor v) {
		v.visitPocion(this);
	}

}
