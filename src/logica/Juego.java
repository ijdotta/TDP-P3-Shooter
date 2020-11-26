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

import javax.swing.JLabel;

import entidades.Entidad;
import entidades.Personaje;
import entidades.jugador.Jugador;
import factories.EntidadFactory;
import factories.jugador.JugadorFactory;
import gui.Ventana_principal;
import movimientos.MHorizontal;
import movimientos.Movimiento;
import niveles.Nivel;
import niveles.NivelUno;

public class Juego {
	
	//Testing
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
		gui.actualizarLabelVidaJugador("Vida: " + jugador.getVida());

		// Inicia el juego desde el nivel uno
		nivel = new NivelUno(this);
		nivel.configurar();
	}

	// Metodos
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
				if (!e1.equals(e2)) {
					obj1 = e1.getEntidadGrafica().getLabelImagen().getBounds();
					obj2 = e2.getEntidadGrafica().getLabelImagen().getBounds();

					if (obj1.intersects(obj2)) {
						e2.accept(e1.getVisitor());
					}
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
		} 
		else if (codigoTecla == (KeyEvent.VK_SPACE)) {
			logger.finer("Tecla: espacio");
			generarDisparo((Personaje) jugador);
		} 
//		else {
//			System.out.println();
//		}

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
		jugador.setLocation((gui.escenarioWidth() / 2) - (jugador.getWidth()/2), (gui.escenarioHeight() - 50) - (jugador.getHeight()/2));
	}
	public void finalizarJuego() {

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
	 * Remueve todas las entidades de la lista y escenario excepto el jugador
	 */
	public void limpiarEscenario() {
		for (Entidad e : entidades) {
			if (!e.equals(jugador)) {
				this.removerEntidad(e);
			}
		}
	}

	// Getter/Setters
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public List<Entidad> getEntidades() {
		return entidades;
	}

	public Ventana_principal getGui() {
		return gui;
	}

	public void setGui(Ventana_principal vp) {
		gui = vp;
	}

	public Jugador getJugador() {
		return (Jugador) jugador;
	}
	public int escenarioWidth() {
		return gui.escenarioWidth();
	}
	
	public int escenarioHeight() {
		return gui.escenarioHeight();
	}
	public void setBackground(String ruta) {
		gui.setBackground(ruta);
	}
	
	public void indicarNivel(String nivel_actual) {
		gui.indicarNivel(nivel_actual);
	}
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
