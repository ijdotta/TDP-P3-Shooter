package entidades.proyectiles;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;
import visitors.Visitor;

public class Proyectil_Jugador extends Proyectil {

	public Proyectil_Jugador(EntidadGrafica eg, Movimiento m, int v, int dmg) {
		super(eg, m, v, dmg);
	}

	@Override
	public void accept(Visitor v) {
		v.visitProjectilJ(this);
	}
	

}
