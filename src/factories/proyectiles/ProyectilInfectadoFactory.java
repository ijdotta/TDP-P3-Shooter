package factories.proyectiles;

import entidades.Entidad;
import entidades.proyectiles.Proyectil_Infectado;
import factories.EntidadFactory;
import logica.Juego;

public class ProyectilInfectadoFactory extends EntidadFactory {

	public ProyectilInfectadoFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		return new Proyectil_Infectado(juego);
	}

}
