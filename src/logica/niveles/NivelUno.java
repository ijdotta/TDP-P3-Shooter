package logica.niveles;

import java.util.Random;

import logica.Juego;
import logica.entidades.Entidad;
import logica.entidades.premios.timers.TimerCuarentena;
import logica.entidades.premios.timers.TimerSuperArma;
import logica.factories.EntidadFactory;
import logica.factories.infectados.InfectadoAlphaFactory;
import logica.factories.infectados.InfectadoBetaFactory;
import logica.factories.premios.PremioPermanentePocionFactory;
import logica.factories.premios.PremioTemporalCuarentenaFactory;
import logica.factories.premios.PremioTemporalSuperArmaFactory;

public class NivelUno extends Nivel {

	public NivelUno(Juego j) {
		super(j);
	}
	/**
	 * Este es un ejemplo de como puede ser configurado un nivel.
	 * Background de pasteleria, nivel Uno, hay 20 infectados total, 10 alpha, 10 beta, todos los premios disponibles, por ahora no tiene nivel siguiente.
	 */
	public void configurar() {
		Random rand = new Random();
		Entidad enti;

		// Background del nivel
		juego.setBackground("/img/Background_Scenery1.png");

		// Indicar graficamente en cual nivel estoy
		juego.indicarNivel("Nivel Uno");

		// Infectados que se van a generan en el nivel		

		fInfectados = new EntidadFactory[2];
		fInfectados[0] = new InfectadoAlphaFactory(juego);
		fInfectados[1] = new InfectadoBetaFactory(juego);

		// Agregando infectados al escenario
		for (int i = 0; i < 10; i++) {
			enti = fInfectados[0].crearEntidad();

			// Para ponerle una posicion inicial.
			enti.setLocation(rand.nextInt((int) juego.escenarioWidth() - enti.getWidth()),
					rand.nextInt(25) - enti.getHeight());

			juego.addEntidad(enti);
			cantidad_infectados++;
		}
		
		for (int i = 0; i < 10; i++) {
			enti = fInfectados[1].crearEntidad();

			// Para ponerle una posicion inicial.
			enti.setLocation(rand.nextInt((int) juego.escenarioWidth() - enti.getWidth()),
					rand.nextInt(25) - enti.getHeight());

			juego.addEntidad(enti);
			cantidad_infectados++;
		}

		// Determinando que premios pueden aparecer en el escenario
		fPremios = new EntidadFactory[3];

		fPremios[0] = new PremioPermanentePocionFactory(juego);
		fPremios[1] = new PremioTemporalCuarentenaFactory(juego);
		fPremios[2] = new PremioTemporalSuperArmaFactory(juego);

		// De cada premio temporal hacerle conocer el juego
		TimerCuarentena.getInstance().setJuego(juego);
		TimerSuperArma.getInstance().setJuego(juego);
		
		// Siguiente nivel
		siguienteNivel = null;
	}
	
}
