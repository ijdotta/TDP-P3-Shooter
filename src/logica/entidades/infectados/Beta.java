package logica.entidades.infectados;

import logica.Juego;
import logica.entidadesGraficas.infectados.GraficoBeta;
import logica.visitors.Visitor;
import logica.visitors.infectados.VisitorBeta;
/**
 * Class Beta Implementacion de un infectado tipo Beta.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class Beta extends Infectado {

	// Constructor
	/**
	 * Inicia el infectado tipo Alpha con 2 de daño, su sprite grafico y su visitor.
	 * 
	 * @param j juego a conocer
	 */
	public Beta(Juego j) {
		super(j);

		entidadGrafica = new GraficoBeta(50, 50);
		damage = 2;
		visitor = new VisitorBeta(this);
	}

	// Metodos
	@Override
	public void accept(Visitor v) {
		v.visitBeta(this);
	}

}
