package entidades.infectados;

import entidades.Personaje;
import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Infectado extends Personaje {
	// Atributos de instancia
	protected int damage;

	// Constructor
	public Infectado(EntidadGrafica eg, Movimiento m, int v, int dmg) {
		super(eg, m, v);
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