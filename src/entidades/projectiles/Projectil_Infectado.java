package entidades.projectiles;

import entidadesGraficas.EntidadGrafica;
import movimientos.Movimiento;
import visitors.Visitor;

public class Projectil_Infectado extends Projectil {

	public Projectil_Infectado(EntidadGrafica eg, Movimiento m, int v, int dmg) {
		super(eg, m, v, dmg);
	}

	@Override
	public void accept(Visitor v) {
		v.visitProjectilI(this);
	}
}
