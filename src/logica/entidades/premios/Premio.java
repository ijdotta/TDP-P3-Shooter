package logica.entidades.premios;

import logica.Juego;
import logica.entidades.Entidad;
import logica.movimientos.MVertical;

public abstract class Premio extends Entidad {

	public Premio(Juego j) {
		super(j);
		movimiento = new MVertical(this, MVertical.DOWN);
	}

}
