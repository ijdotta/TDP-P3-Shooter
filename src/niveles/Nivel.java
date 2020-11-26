package niveles;

import java.util.Random;

import javax.swing.JLabel;

import entidades.Entidad;
import entidades.premios.timers.TimerCuarentena;
import entidades.premios.timers.TimerSuperArma;
import factories.EntidadFactory;
import factories.infectados.InfectadoAlphaFactory;
import factories.infectados.InfectadoBetaFactory;
import factories.premios.PremioPermanentePocionFactory;
import factories.premios.PremioTemporalCuarentenaFactory;
import factories.premios.PremioTemporalSuperArmaFactory;
import logica.Juego;

public abstract class Nivel {

	protected Juego juego;
	protected Nivel siguienteNivel;

	protected int cantidad_infectados;
	protected EntidadFactory[] fInfectados;
	protected EntidadFactory[] fPremios;

	/**
	 * Si hacemos esto así, de alguna forma los niveles pueden reutilizar el método
	 * configurar, pero pueden ir variando las fábricas (y así, el tipo específico
	 * de infectado) desde su propio constructor. Probablemente habrpia que añadir
	 * más varables fInfectados
	 */
	public Nivel(Juego j) {
		juego = j;

		cantidad_infectados = 20;
		fInfectados = new EntidadFactory[3];
		fInfectados[0] = new InfectadoAlphaFactory(juego);
		fInfectados[1] = new InfectadoBetaFactory(juego);

		fPremios = new EntidadFactory[3];
		fPremios[0] = new PremioPermanentePocionFactory(juego);
	}

	/**
	 * Crea la nueva lista de entidades del juego (o vacía la lista vieja y carga
	 * las nuevas entidades en la misma lista [ver como afecta esto a la GUI])
	 */
	public void configurar() {
		Random rand = new Random();
		Entidad enti;
		EntidadFactory[] premios;
		
		// Background del nivel
		juego.setBackground("/img/Background_Scenery1.png");
		
		// Indicar graficamente en cual nivel estoy
		juego.indicarNivel("Nivel Abstracto");

		// Agregando infectados al escenario
		for (int i = 0; i < cantidad_infectados / 2; i++) {
			enti = fInfectados[0].crearEntidad();

			// Para ponerle una posicion inicial.
			enti.setLocation(rand.nextInt((int) juego.escenarioWidth() - enti.getWidth()), rand.nextInt(25) - enti.getHeight());
			
			juego.addEntidad(enti);
		}

		// Determinando que premios pueden aparecer en el escenario
		premios = new EntidadFactory[3];

		premios[0] = new PremioPermanentePocionFactory(juego);
		premios[1] = new PremioTemporalCuarentenaFactory(juego);
		premios[2] = new PremioTemporalSuperArmaFactory(juego);
		
		// De cada premio temporal hacerle conocer el juego
		TimerCuarentena.getInstance().setJuego(juego);
		TimerSuperArma.getInstance().setJuego(juego);
		
		juego.setPremios(premios);
	}

	/**
	 * ¿Se encarga de limpiar el juego y hacer que se limpie la GUI de cosas viejas
	 * del nivel anterior, para configurar el nuevo nivel?
	 */
	public void limpiar() {

	}

	public void siguienteNivel() {
		if (siguienteNivel != null) {
			juego.setNivel(siguienteNivel);
			juego.getNivel().configurar();
		} else {
			juego.finalizarJuego();
		}
	}

	public void setJuego(Juego j) {
		juego = j;
	}
}
