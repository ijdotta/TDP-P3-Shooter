package entidades.projectiles;

import entidades.Entidad;
import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Projectil extends Entidad{
	
	// Atributos de instancia
	int damage;
	
	// Constructor
	public Projectil(Movimiento m, int v, EntidadGrafica eg, int dmg) {
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
