package factories.projectiles;

import entidades.Entidad;
import entidades.projectiles.Projectil_Infectado;
import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.projectiles.GraficoProjectilInfectado;
import factories.EntidadFactory;
import movimientos.MVertical;
import movimientos.Movimiento;

public class ProyectilInfectadoFactory extends EntidadFactory {

	@Override
	public Entidad crearEntidad() {
		Movimiento m = new MVertical(null, MVertical.DOWN);
		EntidadGrafica eg = new GraficoProjectilInfectado(10,10);
		
		Entidad nuevo_pInfectado = new Projectil_Infectado(eg, m, 4, 15);
		m.setEntidad(nuevo_pInfectado);
		
		return nuevo_pInfectado;
	}

}
