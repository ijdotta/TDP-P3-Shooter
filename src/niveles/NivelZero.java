package niveles;

import java.util.List;

import entidades.Entidad;
import factories.EntidadFactory;
import factories.InfectadoAlphaFactory;

public class NivelZero extends Nivel {

	@Override
	public void configurar() {
		// TODO Auto-generated method stub
		List<Entidad> entidades = juego.getEntidades();
		
		for(Entidad e : entidades) {
			//eliminar rastro gráfico, etc.
			entidades.remove(e);
		}
		
		EntidadFactory infectadoFactory = new InfectadoAlphaFactory();
		for (int i = 0; i < 10; i ++) {
			entidades.add(infectadoFactory.crearEntidad());
		}
		
	}

	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		
	}
	
	

}
