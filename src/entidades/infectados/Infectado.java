package entidades.infectados;

import entidades.Personaje;
import entidades.estados.InfectadoDefaultState;
import factories.proyectiles.ProyectilInfectadoFactory;
import logica.Juego;
import movimientos.MVertical;

public abstract class Infectado extends Personaje {
	// Atributos de instancia
	protected int damage;
	
	/**
	 * SUBCLASE DEBE DETERMINAR DMG, VISITOR Y EG
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

	// Metodos
	public int getDamage() {
		return damage;
	}

	public void setDamage(int dmg) {
		damage = dmg;
	}
	
	/**
	 * Si el infectado esta out of bounds me vuelvo a reposicionar
	 */
	public void outOfBounds() {
		if (this.checkOutOfBounds()) {
			juego.reposicionar(this);
		}
	}
	
}