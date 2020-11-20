package entidades.premios;

import entidadesGraficas.premios.GraficoSuperArma;
import logica.Juego;
import visitors.Visitor;

public class EfectoSuperArma extends EfectoTemporal {

	public EfectoSuperArma(Juego j) {
		super(j);
		
		velocidad = 5;
		duracion = 6;
		
		entidadGrafica = new GraficoSuperArma(30, 30);
		
	}

	@Override
	public void accept(Visitor v) {
		v.visitSuperArma(this);
	}
}
