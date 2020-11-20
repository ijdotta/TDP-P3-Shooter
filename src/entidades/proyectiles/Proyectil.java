package entidades.proyectiles;

import entidades.Entidad;
import logica.Juego;

public abstract class Proyectil extends Entidad {

	// Atributos de instancia
	int damage;

	// Constructor
	public Proyectil(Juego j) {
		super(j);
	}

	// Metodos
	public int getDamage() {
		return damage;
	}

	public void setDamage(int dmg) {
		damage = dmg;
	}
}
