package entidades.estados;

import entidades.Entidad;

public class DefaultState implements State {
	
	protected Entidad entidad;
	
	public DefaultState(Entidad e) {
		this.entidad = e;
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mover() {
		entidad.getMovimiento().mover();
	}

}
