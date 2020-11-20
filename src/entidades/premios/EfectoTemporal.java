package entidades.premios;

import logica.Juego;

public abstract class EfectoTemporal extends Premio {

	// Atributos de instancia
	int duracion;

	// Constructor
	public EfectoTemporal(Juego j) {
		super(j);
	}

}
