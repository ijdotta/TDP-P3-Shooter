package factories;

import entidades.Entidad;
import logica.Juego;

public abstract class EntidadFactory {
	// Atributos de instancia
	protected Juego juego;

	// Constructor
	public EntidadFactory(Juego j) {
		juego = j;
	}

	// Metodos
	public abstract Entidad crearEntidad();

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego j) {
		juego = j;
	}
}
