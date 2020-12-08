package logica.entidades.premios.timers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import logica.entidades.premios.EfectoSuperArma;
import logica.factories.proyectiles.ProyectilJugadorFactory;

/**
 * Class TimerSuperArma Implementacion del timer de un premio super arma.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class TimerSuperArma extends TimerP {

	// Atributos
	private static TimerSuperArma timer_super_arma;

	// Constructor
	/**
	 * Inicia el timer con el comportamiento de ponerle al jugador su fabrica de
	 * proyectiles por defecto.
	 */
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
	/**
	 * Retorna la unica instancia del timer super arma
	 * @return unica instancia del timer super arma
	 */
	public static TimerSuperArma getInstance() {
		if (timer_super_arma == null) {
			timer_super_arma = new TimerSuperArma();
		}
		return timer_super_arma;
	}
}
