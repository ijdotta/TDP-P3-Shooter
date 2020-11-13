package niveles;

import logica.Juego;

public abstract class Nivel {
	
	protected Juego juego;
	protected Nivel siguienteNivel;
	
	public void siguienteNivel() {
		if (siguienteNivel != null) {
			juego.setNivel(siguienteNivel);
			juego.getNivel().configurar();
		}
		else {
			juego.finalizarJuego();
		}
	}
	
	/**
	 * Crea la nueva lista de entidades del juego (o vacía la lista vieja y carga las nuevas entidades en 
	 * la misma lista [ver como afecta esto a la GUI])
	 */
	public abstract void configurar();
	
	/**
	 * ¿Se encarga de limpiar el juego y hacer que se limpie la GUI de cosas viejas del nivel anterior, para configurar el nuevo nivel?
	 */
	public abstract void limpiar();
}
