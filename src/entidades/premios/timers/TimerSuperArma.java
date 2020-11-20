package entidades.premios.timers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import entidades.premios.EfectoSuperArma;
import factories.proyectiles.ProyectilJugadorFactory;
import logica.Juego;
/**
 * Con patron Singleton
 * @author
 *
 */
public class TimerSuperArma {
	
	// Atributos
	private static TimerSuperArma timer_super_arma = new TimerSuperArma();
	private Timer timer;
	private Juego juego;
	
	// Constructor
	private TimerSuperArma(){
		
		timer = new Timer(EfectoSuperArma.DURACION, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Devolver el projectil inicial al jugador
				juego.getJugador().setProyectil(new ProyectilJugadorFactory(juego));
				
				timer.stop();
			}
		});
	}
	
	// Metodos
	public static TimerSuperArma getInstance() {
		return timer_super_arma;
	}
	
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
