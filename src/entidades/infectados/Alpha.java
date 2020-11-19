package entidades.infectados;

import entidadesGraficas.EntidadGrafica;
import factories.proyectiles.ProyectilInfectadoFactory;
import logica.Juego;
import movimientos.Movimiento;
import visitors.Visitor;

public class Alpha extends Infectado {

	public Alpha(Juego j, EntidadGrafica eg, Movimiento m, int v, int dmg) {
		super(j, eg, m, v, dmg);
		proyectil = new ProyectilInfectadoFactory(juego);
	}

	@Override
	public void accept(Visitor v) {
		v.visitAlpha(this);
	}

	public void disparar() {
		juego.generarDisparo(this);
	}
}
