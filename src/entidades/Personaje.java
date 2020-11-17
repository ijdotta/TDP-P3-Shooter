package entidades;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Personaje extends Entidad{	

	// Atributos de instancia
	int hp;
	// Constructor
	/**
	 * Personaje inicia con 100 de vida
	 * @param eg
	 * @param m
	 * @param v
	 */
	public Personaje(EntidadGrafica eg, Movimiento m, int v) {
		super(eg, m, v);
		hp = 100;
	}
	// Metodos
	public int getHP()
	{
		return hp;
	}
	
	public void setHP(int val)
	{
		hp = val;
	}
}
