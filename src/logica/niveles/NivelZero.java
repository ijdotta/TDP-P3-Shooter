package logica.niveles;

<<<<<<< HEAD:src/niveles/NivelZero.java
import java.util.Random;

import entidades.Entidad;
import entidades.premios.timers.TimerCuarentena;
import entidades.premios.timers.TimerSuperArma;
import factories.EntidadFactory;
import factories.infectados.InfectadoAlphaFactory;
import factories.infectados.InfectadoBetaFactory;
import factories.premios.PremioPermanentePocionFactory;
import factories.premios.PremioTemporalCuarentenaFactory;
import factories.premios.PremioTemporalSuperArmaFactory;
=======
>>>>>>> ac4a7da6769403a542b10f48b109e09bfe369ce2:src/logica/niveles/NivelZero.java
import logica.Juego;
import logica.entidades.Entidad;
import logica.factories.EntidadFactory;

public class NivelZero extends Nivel {

	public NivelZero(Juego j) {
		super(j);
	}

	@Override
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
		for (int i = 0; i < 1; i++) {
			enti = fInfectados[0].crearEntidad();

			// Para ponerle una posicion inicial.
			enti.setLocation(rand.nextInt((int) juego.escenarioWidth() - enti.getWidth()),
					rand.nextInt(25) - enti.getHeight());

			juego.addEntidad(enti);
			cantidad_infectados++;
		}

		for (int i = 0; i < 1; i++) {
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


	}

}

/**
 * Esto lo creo aca para que compile el c�digo, pero es solo un ejemplo de la
 * din�mica que propongo con el constructor de cada Nivel
 * 
 * La factory real ir�a en el package Factories, pero no quer�a ensuciarlo
 * ahora.
 * 
 * @author Ignacio
 *
 */
class InfectadoSuperAlfaFactory extends EntidadFactory {

	public InfectadoSuperAlfaFactory(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidad crearEntidad() {
		// TODO Auto-generated method stub
		return null;
	}

}