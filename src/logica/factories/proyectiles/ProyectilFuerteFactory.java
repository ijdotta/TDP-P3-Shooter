package logica.factories.proyectiles;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.proyectiles.Proyectil_Fuerte;
import logica.factories.EntidadFactory;

public class ProyectilFuerteFactory extends EntidadFactory {

	public ProyectilFuerteFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		return new Proyectil_Fuerte(juego);
	}

}
