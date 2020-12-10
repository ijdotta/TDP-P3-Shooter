package logica.entidades.infectados;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidadesGraficas.infectados.GraficoAlpha;
import logica.visitors.Visitor;
import logica.visitors.infectados.VisitorAlpha;

/**
 * Class Alpha Implementacion de un infectado tipo Alpha.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class Alpha extends Infectado {
	// Constructor
	/**
	 * Inicia el infectado tipo Alpha con 1 de daño, su sprite grafico y su visitor.
	 * 
	 * @param j juego a conocer
	 */
	public Alpha(Juego j) {
		super(j);
		damage = 2;
		entidadGrafica = new GraficoAlpha();
		visitor = new VisitorAlpha(this);
		velocidad = 2;
	}

	// Metodos
	@Override
	public void accept(Visitor v) {
		v.visitAlpha(this);
	}

	/**
	 * Recibe daño de una entidad, Cuando la vida es inferior al 20% el infectado
	 * tipo Alpha actual duplica su velocidad.
	 */
	@Override
	public void damage(Entidad enemy) {
		super.damage(enemy);
		if (this.vida < VIDA_MAX * 0.2) {
			this.velocidad *= 2;
		}
	}

}
