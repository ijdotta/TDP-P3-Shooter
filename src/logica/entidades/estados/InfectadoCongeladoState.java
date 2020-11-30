package logica.entidades.estados;

import logica.entidades.infectados.Infectado;

public class InfectadoCongeladoState extends InfectadoDefaultState {

	public InfectadoCongeladoState(Infectado infectado) {
		super(infectado);
	}
	
	@Override
	public void disparar() {
		//no hacer nada
	}
	
	@Override
	public void mover() {
		//no hacer nada
	}

}
