package logica.entidades.infectados;

import logica.Juego;
import logica.entidades.Entidad;
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
	 * Inicia el infectado tipo Beta con 2 de daño, su sprite grafico y su visitor.
	 * 
	 * @param j juego a conocer
	 */
	public Beta(Juego j) {
		super(j);

		entidadGrafica = new GraficoBeta();
		damage = 1;
		visitor = new VisitorBeta(this);
	}

	// Metodos
	@Override
	public void accept(Visitor v) {
		v.visitBeta(this);
	}

	/**
	 * Recibe 20% menos de daño de una entidad.
	 * 
	 * @param enemy Enemigo que provoca el daño.
	 */
	public void damage(Entidad enemy) {
		this.vida -= (int) (enemy.getDamage() * 0.80);
	}
}
