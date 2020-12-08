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
/**
 * Class NivelDos Implementacion del nivel dos.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class NivelDos extends Nivel {
	// Atributos de instancia
	private int cantidad_alpha;
	private int cantidad_beta;
	// Constructor
	/**
	 * Inicia el nivel uno
	 * @param j juego a conocer
	 */
	public NivelDos(Juego j) {
		super(j);
	}

	// Metodos
	/**
	 * Background de la costa, nivel Dos, hay xx infectados total, xx alpha, xx
	 * beta, todos los premios disponibles, no hay siguiente nivel.
	 */
	public void configurar() {
		// Cantidad de infectados
				cantidad_alpha=7;
				cantidad_beta=6;
				cantidad_infectados=cantidad_beta+cantidad_alpha;
				cant_primeraTanda=(cantidad_beta/2)+(cantidad_alpha/2);
				// Siguiente nivel
				siguienteNivel= new NivelDos(juego);
				
				// Background del nivel
				juego.setBackground("/img/background_Scenery20.png");
				
				// Indicar graficamente en cual nivel estoy
				juego.indicarNivel("Nivel Dos");
				
				//Agrego la primera tanda de infecados
				this.primeraTanda();
				
				// Determinando que premios pueden aparecer en el escenario
				fPremios = new EntidadFactory[3];

				fPremios[0] = new PremioPermanentePocionFactory(juego);
				fPremios[1] = new PremioTemporalCuarentenaFactory(juego);
				fPremios[2] = new PremioTemporalSuperArmaFactory(juego);

				// De cada premio temporal hacerle conocer el juego
				TimerCuarentena.getInstance().setJuego(juego);
				TimerSuperArma.getInstance().setJuego(juego);
				
				siguienteNivel=null;
	}

	/**
	 * se genera la primer mitad de infectados alpha y beta indicados en configurar().
	 */
	public void primeraTanda() {
		Random rand = new Random();
		Entidad enti;
		// Infectados que se van a generan en el nivel

				fInfectados = new EntidadFactory[2];
				fInfectados[0] = new InfectadoAlphaFactory(juego);
				fInfectados[1] = new InfectadoBetaFactory(juego);

				// Agregando infectados al escenario
				for (int i = 0; i <cantidad_alpha/2; i++) {
					enti = fInfectados[0].crearEntidad();
					// Para ponerle una posicion inicial.
					enti.setLocation(rand.nextInt((int) juego.escenarioWidth() - enti.getWidth()),
							rand.nextInt(25) - enti.getHeight());

					juego.addEntidad(enti);
				}

				for (int i = 0; i < cantidad_beta/2; i++) {
					enti = fInfectados[1].crearEntidad();

					// Para ponerle una posicion inicial.
					enti.setLocation(rand.nextInt((int) juego.escenarioWidth() - enti.getWidth()),
							rand.nextInt(25) - enti.getHeight());

					juego.addEntidad(enti);
				}
				cantidad_alpha=cantidad_alpha-(cantidad_alpha/2);
				cantidad_beta=cantidad_beta-(cantidad_beta/2);
		
	}

	/**
	 * se genera la segunda mitad de infectados alpha y beta indicados en configurar().
	 */
	public void segundaTanda() {
		Random rand = new Random();
		Entidad enti;
		// Infectados que se van a generan en el nivel

				fInfectados = new EntidadFactory[2];
				fInfectados[0] = new InfectadoAlphaFactory(juego);
				fInfectados[1] = new InfectadoBetaFactory(juego);

		// Agregando infectados al escenario
		for (int i = 0; i <cantidad_alpha; i++) {
			enti = fInfectados[0].crearEntidad();
			// Para ponerle una posicion inicial.
			enti.setLocation(rand.nextInt((int) juego.escenarioWidth() - enti.getWidth()),
			rand.nextInt(25) - enti.getHeight());
			juego.addEntidad(enti);
		}
		
		for (int i = 0; i < cantidad_beta; i++) {
			enti = fInfectados[1].crearEntidad();

			// Para ponerle una posicion inicial.
			enti.setLocation(rand.nextInt((int) juego.escenarioWidth() - enti.getWidth()),
			rand.nextInt(25) - enti.getHeight());
			juego.addEntidad(enti);
		}
		
	}

}
