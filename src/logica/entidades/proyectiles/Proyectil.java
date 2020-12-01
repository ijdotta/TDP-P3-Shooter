package logica.entidades.proyectiles;

import logica.Juego;
import logica.entidades.Entidad;

public abstract class Proyectil extends Entidad {

	// Constructor
	public Proyectil(Juego j) {
		super(j);
	}
	
	public void destruir() {
		this.vida = -1;
	}

}