package entidades.proyectiles;

import entidades.Entidad;
import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Proyectil extends Entidad{
	
	// Atributos de instancia
	int damage;
	
	// Constructor
	public Proyectil(EntidadGrafica eg, Movimiento m, int v, int dmg) {
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
