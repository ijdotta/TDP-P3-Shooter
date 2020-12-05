package logica;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import gui.Ventana_principal;
import logica.entidades.Entidad;
import logica.entidades.Personaje;
import logica.entidades.jugador.Jugador;
import logica.factories.EntidadFactory;
import logica.factories.jugador.JugadorFactory;
import logica.movimientos.MHorizontal;
import logica.movimientos.Movimiento;
import logica.niveles.Nivel;
import logica.niveles.NivelUno;

/**
 * Class Juego Implementacion del juego.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class Juego {

	// Testing
	private static Logger logger;

	// Atributos de instancia
	private Ventana_principal gui;
	private List<Entidad> entidades;
	private Entidad jugador;
	private Nivel nivel;
	private EntidadFactory factoryJugador;

	// Constructor
	/**
	 * Inicia el juego con el jugador centrado en la parte inferior y se configura
	 * el resto del escenario segun el nivel.
	 * 
	 * @param vp Ventana Principal de la gui
	 */
	public Juego(Ventana_principal vp) {
		inicializarLogger();

		this.gui = vp;
		entidades = new LinkedList<Entidad>();
		factoryJugador = new JugadorFactory(this);

		// El primero de la lista es el jugador
		jugador = factoryJugador.crearEntidad();
		posicionInicialJugador();
		this.addEntidad(jugador);
		this.actualizarVidaJugador(jugador.getVida());

		// Dejar iniciado el juego desde el primer nivel
		primerNivel();
	}

	// Metodos
	/**
	 * le pide a la gui que actualize la vida del jugador en display
	 * 
	 * @param vida vida actual del jugador
	 */
	public void actualizarVidaJugador(int vida) {
		gui.actualizarLabelVidaJugador("Vida: " + vida);
	}

	/**
	 * Setea el nivel actual al primer nivel
	 */
	private void primerNivel() {
		nivel = new NivelUno(this);
	}

	/**
	 * Logica principal del juego. Se encarga de mover, accionar y remover
	 * entidades, asi como tambien se encarga de detectar colisiones.
	 */
	public void accionar() {
		List<Entidad> quieren_disparar, a_eliminar;
		quieren_disparar = new LinkedList<Entidad>();
		a_eliminar = new LinkedList<Entidad>();

		Rectangle obj1, obj2;
		Random rand = new Random();

		// Mover las entidades y preguntarles si quieren disparar
		for (Entidad e : entidades) {
			if (!e.equals(jugador)) {
				e.mover();

				// Hago un random para saber si quiere disparar
				// Para que no dispare todo el tiempo, tiene 1/100 chances de disparar
				if (rand.nextInt(100) == 0) {
					quieren_disparar.add(e);
				}
			}
		}

		// Hacer que disparen los que ganaron derecho a disparar
		for (Entidad e : quieren_disparar) {
			e.disparar();
		}

		// Detectar colisiones/ Realizar interacciones.
		for (Entidad e1 : entidades) {
			for (Entidad e2 : entidades) {
				obj1 = e1.getEntidadGrafica().getLabelImagen().getBounds();
				obj2 = e2.getEntidadGrafica().getLabelImagen().getBounds();

				if (obj1.intersects(obj2)) {
					e2.accept(e1.getVisitor());
				}
			}
		}

		// Chequear si hay entidades muertas
		for (Entidad e : entidades) {
			// Preguntar si esta fuera del escenario.
			e.outOfBounds();

			// Ver si la entidad esta muerta
			if (e.getVida() <= 0) {
				a_eliminar.add(e);
			}
		}

		// Para aquella entidades que murieron les pregunto si tienen alguna accion al
		// morir
		// luego las elimino
		for (Entidad e : a_eliminar) {
			e.morir();
			removerEntidad(e);
		}
		perderJuego();
	}

	/**
	 * Recibe los input de la gui
	 * 
	 * @param e input a recibir
	 */
	public void recibirInput(KeyEvent e) {
		int codigoTecla = e.getKeyCode();

		if ((codigoTecla == KeyEvent.VK_LEFT) || (codigoTecla == (KeyEvent.VK_RIGHT))) {
			moverJugador(e);
		} else if (codigoTecla == (KeyEvent.VK_SPACE)) {
			logger.finer("Tecla: espacio");
			generarDisparo((Personaje) jugador);
		}
	}

	/**
	 * Segun el input recibido mueve al jugador a izquierda o derecha
	 * 
	 * @param e input del teclado
	 */
	private void moverJugador(KeyEvent e) {
		int codigoTecla = e.getKeyCode();
		Movimiento movimientoj = jugador.getMovimiento();

		if (codigoTecla == KeyEvent.VK_LEFT) {
			logger.finer("Tecla: izquierda");
			movimientoj.setDireccion(MHorizontal.LEFT);
		} else if (codigoTecla == KeyEvent.VK_RIGHT) {
			logger.finer("Tecla: derecha");
			movimientoj.setDireccion(MHorizontal.RIGHT);
		}

		movimientoj.mover();
	}

	/**
	 * Se genera un disparo segun el proyectil que tenga la entidad pasada por
	 * parametro. se genera detras y centrado en la entidad.
	 * 
	 * @param enti entidad la cual dispara
	 */
	public void generarDisparo(Personaje enti) {
		Entidad projectil = enti.getProyectil().crearEntidad();

		// Posiciono el disparo en el centro de la entidad
		projectil.setLocation(enti.getX() + (enti.getWidth() / 2) - (projectil.getWidth() / 2),
				enti.getY() + (enti.getHeight() / 2) - (projectil.getHeight() / 2));

		// Introduzco el label en la capa del medio, asi esta abajo del infectado y
		// encima del background
		this.addEntidad1(projectil);
	}

	/**
	 * Se le pide al nivel un premio al azar, si es que existe
	 * 
	 * @param enti entidad la cual suelta el premio
	 */
	public void generarPremio(Entidad enti) {
		Entidad premio;

		if (nivel.hayPremio()) {
			premio = nivel.getPremioRandom();

			// Posiciono el premio en el centro de la entidad
			premio.setLocation(enti.getX() + (enti.getWidth() / 2) - (premio.getWidth() / 2),
					enti.getY() + (enti.getHeight() / 2) - (premio.getHeight() / 2));

			// Introduzco el label en la capa del medio, asi esta abajo del infectado y
			// encima del background
			this.addEntidad1(premio);
		}
	}

	/**
	 * Remueve la entidad de la lista y graficamente del escenario.
	 * 
	 * @param enti entidad a remover
	 */
	public void removerEntidad(Entidad enti) {
		gui.removeComponent(enti.getLabelImagen());
		entidades.remove(enti);
		logger.info("***Removido*** Entidad: " + enti.toString());
	}

	/**
	 * Agrega la entidad a la lista y graficamente al escenario en la capa superior
	 * 
	 * @param enti entidad a agregar
	 */
	public void addEntidad(Entidad enti) {
		entidades.add(enti);
		gui.addComponent(enti.getLabelImagen());
	}

	/**
	 * agrega la entidad a la lista y graficamente al escenario en la capa del medio
	 * 
	 * @param enti entidad a agregar
	 */
	public void addEntidad1(Entidad enti) {
		// logger.info("***Generado***"+enti.toString());
		entidades.add(enti);
		gui.addComponent1(enti.getLabelImagen());
	}

	/**
	 * Reposiciona una entidad en el tope dentro del rango del jugador. Esta pensada
	 * para ser utilizada para los infectados que se salgan de la pantalla.
	 * 
	 * @param enti Entidad a reposicionar
	 */
	public void reposicionarInfectado(Entidad enti) {
		int x, y;
		Random rand = new Random();

		x = jugador.getX() - 100 + rand.nextInt(200);
		y = 1 - enti.getHeight();

		enti.setLocation(x, y);
	}

	/**
	 * Posiciona al jugador en su posicion inicial.
	 */
	public void posicionInicialJugador() {
		jugador.setLocation((gui.escenarioWidth() / 2) - (jugador.getWidth() / 2),
				(gui.escenarioHeight() - 50) - (jugador.getHeight() / 2));
	}

	/**
	 * hace que el juego se gane
	 */
	public void finalizarJuego() {
		gui.ganarJuego();
	}

	/**
	 * Si el jugador pierde su vida, el juego termina
	 */
	public void perderJuego() {
		if (jugador.getVida() <= 0) {
			gui.perderJuego();
		}
	}

	/**
	 * Remueve todas las entidades de la lista y el escenario.
	 */
	public void limpiarEscenario() {
		// Remuevo graficamente a todas las entidades de la lista
		for (Entidad e : entidades) {
			gui.removeComponent(e.getLabelImagen());
		}

		// Creo una nueva lista de entidades vacia.
		entidades = new LinkedList<Entidad>();
	}

	/**
	 * Inicia el nivel actual para que se generen las entidades correspondientes, Se
	 * limpia cualquier residuo excepto el jugador.
	 */
	public void iniciarNivel() {
		limpiarTodoMenosJugador();

		nivel.configurar();
	}

	/**
	 * Remueve todas las entidades de la lista y graficamente del escenarios,
	 * excepto el jugador
	 */
	public void limpiarTodoMenosJugador() {
		// Remuevo graficamente a todas las entidades de la lista
		for (Entidad e : entidades) {
			gui.removeComponent(e.getLabelImagen());
		}

		// Creo una nueva lista de entidades vacia.
		entidades = new LinkedList<Entidad>();
		this.addEntidad(jugador);
	}

	/**
	 * Reinicia el juego, limpiando el escenario, dejando al jugador como nuevo e
	 * iniciando desde el primer nivel.
	 */
	public void reiniciarJuego() {
		// Limpiar todo el escenario
		this.limpiarEscenario();

		// Crear un jugador nuevo, alternativa para que empieze denuevo con 100 de vida.
		jugador = factoryJugador.crearEntidad();
		posicionInicialJugador();
		this.addEntidad(jugador);
		gui.actualizarLabelVidaJugador("Vida: " + jugador.getVida());

		// Dejar cargado el primer nivel
		primerNivel();
	}

	// Getter/Setters
	/**
	 * Settea el nivel actual con el que es pasado por parametro.
	 * 
	 * @param nivel nivel nuevo
	 */
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	/**
	 * Retorna el nivel actual
	 * @return nivel actual
	 */
	public Nivel getNivel() {
		return nivel;
	}

	/**
	 * Retorna la lista de entidades actual
	 * @return lista de entidades actual
	 */
	public List<Entidad> getEntidades() {
		return entidades;
	}
	/**
	 * Retorna la gui actual
	 * @return gui actual
	 */
	public Ventana_principal getGui() {
		return gui;
	}
	/**
	 * Settea la gui actual con la que es pasado por parametro.
	 * 
	 * @param vp gui nueva
	 */
	public void setGui(Ventana_principal vp) {
		gui = vp;
	}
	/**
	 * Retorna el jugador actual
	 * @return jugador actual
	 */
	public Jugador getJugador() {
		return (Jugador) jugador;
	}

	/**
	 * Retorna el ancho del escenario
	 * @return ancho del escenario
	 */
	public int escenarioWidth() {
		return gui.escenarioWidth();
	}
	/**
	 * Retorna el alto del escenario
	 * @return alto del escenario
	 */
	public int escenarioHeight() {
		return gui.escenarioHeight();
	}
	/**
	 * Settea el background del escenario segun la ruta pasada por parametro.
	 * 
	 * @param ruta ruta de la imagen
	 */
	public void setBackground(String ruta) {
		gui.setBackground(ruta);
	}

	/**
	 * le pide a la gui que actualize el nivel en display segun lo pasado por parametro
	 * @param nivel_actual texto con el nivel que se quiere mostrar
	 */
	public void indicarNivel(String nivel_actual) {
		gui.indicarNivel(nivel_actual);
	}

	/**
	 * le pide al nivel que decremente la cantidad de infectados.
	 */
	public void decrementarInfectados() {
		nivel.decrementarInfectados();
	}

	/**
	 * Inicio del logger
	 */
	private void inicializarLogger() {
		if (logger == null) {

			logger = Logger.getLogger(this.getClass().getName());

			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.ALL);
			logger.addHandler(hnd);

			logger.setLevel(Level.ALL);

			Logger rootLoger = logger.getParent();
			for (Handler h : rootLoger.getHandlers())
				h.setLevel(Level.OFF);
		}
	}

}
