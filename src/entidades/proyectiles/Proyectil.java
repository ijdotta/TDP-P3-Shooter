package entidades.proyectiles;

import entidades.Entidad;
import logica.Juego;
import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Proyectil extends Entidad {

	// Atributos de instancia
	int damage;

	// Constructor
	public Proyectil(Juego j, EntidadGrafica eg, Movimiento m, int v, int dmg) {
		super(j, eg, m, v);
		damage = dmg;
	}

	// Metodos
	public int getDamage() {
		return damage;
	}

	public void setDamage(int dmg) {
		damage = dmg;
	}
}
