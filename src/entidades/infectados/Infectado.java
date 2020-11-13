package entidades.infectados;

import entidades.Personaje;

public abstract class Infectado extends Personaje{
	protected int daño;
	protected int vida;
	
	public int getVida() {
		return vida;
	}
}
