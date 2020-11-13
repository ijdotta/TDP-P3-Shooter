package entidades;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;

public abstract class Personaje  extends Entidad{	

	// Atributos de instancia
	int hp;
	// Constructor
	public Personaje(Movimiento m, int v, EntidadGrafica eg) {
		super(m, v, eg);
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
