package logica.entidades.premios.timers;

import javax.swing.Timer;

import logica.Juego;

public abstract class TimerP {
	
	// Atributos
	protected Timer timer;
	protected Juego juego;
	
	// Metodos	
	public void start() {
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}
	
	public void restart() {
		timer.restart();
	}
	
	public boolean isRunning() {
		return timer.isRunning();
	}
	
	// Setters / Getters
	public void setJuego(Juego j) {
		juego = j;
	}
}
