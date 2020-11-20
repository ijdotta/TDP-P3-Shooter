package entidades.premios;

import entidadesGraficas.premios.GraficoCuarentena;
import logica.Juego;
import visitors.Visitor;

public class EfectoCuarentena extends EfectoTemporal {

	public EfectoCuarentena(Juego j) {
		super(j);
		
		velocidad = 5;
		duracion = 4;
		
		entidadGrafica = new GraficoCuarentena(30, 30);
	}

	@Override
	public void accept(Visitor v) {
		v.visitCuarentena(this);
	}

}
