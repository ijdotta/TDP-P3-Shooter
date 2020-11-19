package entidades.infectados;

import entidades.Personaje;
import entidades.estados.InfectadoDefaultState;
import entidades.estados.State;
import entidadesGraficas.EntidadGrafica;
import logica.Juego;
import movimientos.Movimiento;

public abstract class Infectado extends Personaje {
	// Atributos de instancia
	protected int damage;
	
	// Constructor
	public Infectado(Juego j, EntidadGrafica eg, Movimiento m, int v, int dmg) {
		super(j, eg, m, v);
		state = new InfectadoDefaultState(this);
		damage = dmg;
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