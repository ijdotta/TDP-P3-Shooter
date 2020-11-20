package factories.proyectiles;

import entidades.Entidad;
import entidades.proyectiles.Proyectil_Fuerte;
import factories.EntidadFactory;
import logica.Juego;

public class ProyectilFuerteFactory extends EntidadFactory{

	public ProyectilFuerteFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		return new Proyectil_Fuerte(juego);
	}

}
