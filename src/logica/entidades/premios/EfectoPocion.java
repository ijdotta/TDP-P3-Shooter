package logica.entidades.premios;

import logica.Juego;
import logica.entidadesGraficas.premios.GraficoPocion;
import logica.visitors.Visitor;
import logica.visitors.premios.VisitorPocion;

public class EfectoPocion extends EfectoPermanente {

	// Atributos de instancia
	public static final int CURACION = 25;
	// Constructor
	public EfectoPocion(Juego j) {
		super(j);
		
		velocidad = 5;
		entidadGrafica = new GraficoPocion(30, 30);
		
		visitor = new VisitorPocion(this);
	}

	// Metodos
	@Override
	public void accept(Visitor v) {
		v.visitPocion(this);
	}

}
