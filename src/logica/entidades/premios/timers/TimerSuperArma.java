package logica.entidades.premios.timers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

<<<<<<< HEAD:src/entidades/premios/timers/TimerSuperArma.java
import entidades.premios.EfectoSuperArma;
import factories.proyectiles.ProyectilJugadorFactory;

=======
import logica.entidades.premios.EfectoSuperArma;
import logica.factories.proyectiles.ProyectilJugadorFactory;
>>>>>>> ac4a7da6769403a542b10f48b109e09bfe369ce2:src/logica/entidades/premios/timers/TimerSuperArma.java
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
