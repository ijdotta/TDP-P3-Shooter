package entidades.infectados;

import entidades.Personaje;
import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Infectado extends Personaje {
	// Atributos de instancia
	protected int damage;

	// Constructor
	public Infectado(Movimiento m, int v, EntidadGrafica eg, int dmg) {
		super(m, v, eg);
		damage = dmg;
	}

	// Metodos
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int dmg)
	{
		damage = dmg;
	}
}