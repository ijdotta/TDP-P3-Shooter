package logica.factories.proyectiles;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.proyectiles.Proyectil_Infectado;
import logica.factories.EntidadFactory;

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
