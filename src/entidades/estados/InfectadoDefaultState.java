package entidades.estados;

import entidades.infectados.Infectado;

public class InfectadoDefaultState implements State {
	
	protected Infectado infectado;
	
	public InfectadoDefaultState(Infectado infectado) {
		this.infectado = infectado;
	}

	@Override
	public void disparar() {
		infectado.getJuego().generarDisparo(infectado);
	}

	@Override
	public void morir() {
		infectado.getJuego().generarPremio(infectado);
	}

	@Override
	public void mover() {
		infectado.getMovimiento().mover();
	}

}
