package logica.entidades.estados;

import java.util.Random;

import logica.entidades.infectados.Infectado;

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
		Random r = new Random();
		//P(soltarPremio) = 1/3
		if (r.nextInt(3) == 0) {
			infectado.getJuego().generarPremio(infectado);
		}
	}

	@Override
	public void mover() {
		infectado.getMovimiento().mover();
	}

}
