package logica.entidades.infectados;

import logica.Juego;
import logica.entidades.Personaje;
import logica.entidades.estados.InfectadoDefaultState;
import logica.factories.proyectiles.ProyectilInfectadoFactory;
import logica.movimientos.MVertical;
import logica.visitors.Visitor;

public abstract class Infectado extends Personaje {

	/**
	 * SUBCLASE DEBE DETERMINAR DMG, VISITOR Y EG
	 * 
	 * @param j
	 * @param eg
	 * @param m
	 * @param v
	 * @param dmg
	 */
	public Infectado(Juego j) {
		super(j);
		velocidad = 1;
		movimiento = new MVertical(this, MVertical.DOWN);
		state = new InfectadoDefaultState(this);
		proyectil = new ProyectilInfectadoFactory(juego);
	}

	// subí damage a las entidades porque me sirve para el método damage

	/**
	 * Si el infectado esta out of bounds me vuelvo a reposicionar
	 */
	public void outOfBounds() {
		if (this.checkOutOfBounds()) {
			juego.reposicionarInfectado(this);
		}
	}

}