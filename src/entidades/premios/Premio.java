package entidades.premios;

import entidades.Entidad;
import logica.Juego;
import movimientos.MVertical;

public abstract class Premio extends Entidad {

	public Premio(Juego j) {
		super(j);
		movimiento = new MVertical(this, MVertical.DOWN);
	}

}
