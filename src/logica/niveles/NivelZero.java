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

	@Override
	public void primeraTanda() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void segundaTanda() {
		// TODO Auto-generated method stub
		
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
