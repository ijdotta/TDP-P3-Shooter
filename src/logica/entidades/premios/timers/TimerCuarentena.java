package logica.entidades.premios.timers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import logica.entidades.Entidad;
import logica.entidades.premios.EfectoCuarentena;
import logica.visitors.premios.VisitorNormalizarInfectado;

/**
 * Class TimerCuarentena Implementacion del timer de un premio cuarentena.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class TimerCuarentena extends TimerP {

	// Atributos
	private static TimerCuarentena timer_cuarentena;

	// Constructor
	/**
	 * Inicia el timer con el comportamiento de ponerle a los infectados un state
	 * normal.
	 */
	private TimerCuarentena() {

		timer = new Timer(EfectoCuarentena.DURACION, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Devolver el estado normal del infectado
				for (Entidad enti : juego.getEntidades()) {
					enti.accept(new VisitorNormalizarInfectado());
				}

				timer.stop();
			}
		});
	}

	// Metodos
	/**
	 * Retorna la unica instancia del timer cuarentena
	 * @return unica instancia del timer cuarentena
	 */
	public static TimerCuarentena getInstance() {
		if (timer_cuarentena == null) {
			timer_cuarentena  = new TimerCuarentena();
		}
		return timer_cuarentena;
	}
}
