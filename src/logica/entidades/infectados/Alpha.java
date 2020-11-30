package logica.entidades.infectados;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidadesGraficas.infectados.GraficoAlpha;
import logica.visitors.Visitor;
import logica.visitors.infectados.VisitorAlpha;

public class Alpha extends Infectado {
	
	protected static int VIDA_MAX = 200;
	
	public Alpha(Juego j) {
		super(j);
		vida = VIDA_MAX;
		damage = 1;
		entidadGrafica = new GraficoAlpha(50, 50);
		visitor = new VisitorAlpha(this);
		System.out.println("Creando alpha con vida = " + this.vida + " y vida max = " + VIDA_MAX);
	}

	@Override
	public void accept(Visitor v) {
		v.visitAlpha(this);
	}
	
	/**
	 * Cuando la vida es inferior al 20% Alpha duplica su velocidad.
	 */
	@Override
	public void damage(Entidad enemy) {
		super.damage(enemy);
		if (this.vida < VIDA_MAX * 0.2) {
			this.velocidad *= 2;
		}
	}

}
