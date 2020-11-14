package entidades.projectiles;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;
import visitors.Visitor;

public class Projectil_Jugador extends Projectil {

	public Projectil_Jugador(EntidadGrafica eg, Movimiento m, int v, int dmg) {
		super(eg, m, v, dmg);
	}

	@Override
	public void accept(Visitor v) {
		v.visitProjectilJ(this);
	}
	

}
