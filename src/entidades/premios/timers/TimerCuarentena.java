package entidades.premios.timers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import entidades.Entidad;
import entidades.premios.EfectoCuarentena;
import logica.Juego;
import visitors.premios.VisitorNormalizarInfectado;

/**
 * Con patron singleton
 * @author
 *
 */
public class TimerCuarentena {

	// Atributos
	private static TimerCuarentena timer_cuarentena = new TimerCuarentena();
	private Timer timer;
	private Juego juego;
	
	// Constructor
	private TimerCuarentena(){
		
		timer = new Timer(EfectoCuarentena.DURACION, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Devolver el estado normal del infectado
				for(Entidad enti: juego.getEntidades()) {
					enti.accept(new VisitorNormalizarInfectado());
				}
				
				timer.stop();
			}
		});
	}
	
	// Metodos
	public static TimerCuarentena getInstance() {
		return timer_cuarentena;
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
