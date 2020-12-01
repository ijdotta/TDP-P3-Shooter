package logica.entidades.premios.timers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import logica.entidades.premios.EfectoSuperArma;
import logica.factories.proyectiles.ProyectilJugadorFactory;

/**
 * Con patron Singleton
 * 
 * @author
 *
 */
public class TimerSuperArma extends TimerP {

	// Atributos
	private static TimerSuperArma timer_super_arma = new TimerSuperArma();

	// Constructor
	private TimerSuperArma() {

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
}
