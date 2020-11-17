package factories.proyectiles;

import entidades.Entidad;
import entidades.proyectiles.Proyectil_Infectado;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.proyectiles.GraficoProyectilInfectado;
import factories.EntidadFactory;
import movimientos.MVertical;
import movimientos.Movimiento;

public class ProyectilInfectadoFactory extends EntidadFactory {

	@Override
	public Entidad crearEntidad() {
		Movimiento m = new MVertical(null, MVertical.DOWN);
		EntidadGrafica eg = new GraficoProyectilInfectado(10,10);
		
		Entidad nuevo_pInfectado = new Proyectil_Infectado(eg, m, 4, 15);
		m.setEntidad(nuevo_pInfectado);
		
		return nuevo_pInfectado;
	}

}
