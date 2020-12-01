package logica.entidades.premios.timers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import logica.entidades.Entidad;
import logica.entidades.premios.EfectoCuarentena;
import logica.visitors.premios.VisitorNormalizarInfectado;

/**
 * Con patron singleton
 * 
 * @author
 *
 */
public class TimerCuarentena extends TimerP {

	// Atributos
	private static TimerCuarentena timer_cuarentena = new TimerCuarentena();

	// Constructor
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
	public static TimerCuarentena getInstance() {
		return timer_cuarentena;
	}
}
