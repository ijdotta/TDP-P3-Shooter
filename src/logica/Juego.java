package logica;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
	// Atributos de instancia
	private Ventana_principal gui;
	private List<Entidad> entidades;
	private Entidad jugador;
	private Nivel nivel;
	private EntidadFactory factoryJugador;
	private EntidadFactory[] premios;

	// Constructor
	/**
	 * Inicia el juego con el jugador centrado en la parte inferior y se configura
	 * el resto del escenario segun el nivel.
	 * 
	 * @param vp Ventana Principal de la gui
	 */
	public Juego(Ventana_principal vp) {
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

		System.out.print("Tecla ");
		if ((codigoTecla == KeyEvent.VK_LEFT) || (codigoTecla == (KeyEvent.VK_RIGHT))) {
			moverJugador(e);
		} else if (codigoTecla == (KeyEvent.VK_SPACE)) {
			System.out.println("Espacio");
			generarDisparo((Personaje) jugador);
		} else {
			System.out.println();
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
			System.out.println("Izquierda");
			movimientoj.setDireccion(MHorizontal.LEFT);
		} else if (codigoTecla == KeyEvent.VK_RIGHT) {
			System.out.println("Derecha");
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
		JLabel lblE, lblP;

		lblE = enti.getEntidadGrafica().getLabelImagen();
		lblP = projectil.getEntidadGrafica().getLabelImagen();

		// Posiciono el disparo en el centro de la entidad
		lblP.setLocation(lblE.getX() + (lblE.getWidth() / 2) - (lblP.getWidth() / 2),
				lblE.getY() + (lblE.getHeight() / 2) - (lblP.getHeight() / 2));

		// Introduzco el label en la capa del medio, asi esta abajo del infectado y
		// encima del background
		this.addEntidad1(projectil);
	}

	/**
	 * Se genera un premio al azar de los disponibles detras y en el centro de la
	 * entidad pasada por parametro.
	 * 
	 * @param enti entidad la cual suelta el premio
	 */
	public void generarPremio(Entidad enti) {
		Entidad premio;
		Random rand;
		JLabel lblE, lblP;

		// Se genera un premio al azar de los disponibles, si es que existe
		if (premios.length > 0) {
			rand = new Random();
			premio = premios[rand.nextInt(premios.length)].crearEntidad();
			// premio = premios[1].crearEntidad();

			lblE = enti.getEntidadGrafica().getLabelImagen();
			lblP = premio.getEntidadGrafica().getLabelImagen();

			// Posiciono el premio en el centro de la entidad
			lblP.setLocation(lblE.getX() + (lblE.getWidth() / 2) - (lblP.getWidth() / 2),
					lblE.getY() + (lblE.getHeight() / 2) - (lblP.getHeight() / 2));

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
		gui.removeComponent(enti.getEntidadGrafica().getLabelImagen());
		entidades.remove(enti);
		System.out.println("***Removido*** Entidad: " + enti.toString());
	}

	/**
	 * Agrega la entidad a la lista y graficamente al escenario en la capa superior
	 * 
	 * @param enti entidad a agregar
	 */
	public void addEntidad(Entidad enti) {
		entidades.add(enti);
		gui.addComponent(enti.getEntidadGrafica().getLabelImagen());
	}

	/**
	 * agrega la entidad a la lista y graficamente al escenario en la capa del medio
	 * 
	 * @param enti entidad a agregar
	 */
	public void addEntidad1(Entidad enti) {
		// System.out.println("***Generado***"+enti.toString());
		entidades.add(enti);
		gui.addComponent1(enti.getEntidadGrafica().getLabelImagen());
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

		x = jugador.getEntidadGrafica().getLabelImagen().getX() - 100 + rand.nextInt(200);
		y = 1 - enti.getEntidadGrafica().getLabelImagen().getHeight();

		enti.getEntidadGrafica().getLabelImagen().setLocation(x, y);
	}
	/**
	 * Pone al jugador en su posicion inicial.
	 */
	public void posicionInicialJugador() {
		JLabel lblJ = jugador.getEntidadGrafica().getLabelImagen();
		jugador.getEntidadGrafica().getLabelImagen().setLocation((gui.getWidth() / 2) - (lblJ.getWidth()/2), (gui.getHeight() - 100) - (lblJ.getHeight()/2));
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

	public void setPremios(EntidadFactory[] p) {
		premios = p;
	}

	public Jugador getJugador() {
		return (Jugador) jugador;
	}
}
