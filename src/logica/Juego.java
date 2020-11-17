package logica;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

import entidades.Entidad;
import entidades.Personaje;
import entidades.infectados.Infectado;
import factories.EntidadFactory;
import factories.jugador.JugadorFactory;
import factories.proyectiles.ProyectilJugadorFactory;
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
	private EntidadFactory factoryProjectilJugador;

	// Constructor
	public Juego(Ventana_principal vp) {
		this.gui = vp;
		entidades = new LinkedList<Entidad>();
		factoryJugador = new JugadorFactory(this);
		factoryProjectilJugador = new ProyectilJugadorFactory(this);

		// El primero de la lista es el jugador
		jugador = factoryJugador.crearEntidad();
		jugador.getEntidadGrafica().getLabelImagen().setLocation(350, 475);
		entidades.add(jugador);
		gui.addComponent(jugador.getEntidadGrafica().getLabelImagen());

		// Inicia el juego desde el nivel uno
		nivel = new NivelUno(this);
		nivel.configurar();
	}

	// Metodos
	public void accionar() {
		List<Entidad> quieren_disparar = new LinkedList<Entidad>();
		Rectangle obj1, obj2;
		Random rand = new Random();

		// Mover las entidades y preguntarles si quieren disparar
		for (Entidad e : entidades) {
			if (!e.equals(jugador)) {
				e.getMovimiento().mover();

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

		// Detectar colisiones
		for (Entidad e1 : entidades) {
			for (Entidad e2 : entidades) {
				if (!e1.equals(e2)) {
					obj1 = e1.getEntidadGrafica().getLabelImagen().getBounds();
					obj2 = e2.getEntidadGrafica().getLabelImagen().getBounds();

					if (obj1.intersects(obj2)) {
						// System.out.println("Locacion: x: "+obj1.getX()+" y: "+obj1.getY()+"
						// nombre_obj: "+e1.toString());
						e2.accept(e1.getVisitor());
					}
				}
			}
		}
	}

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

	public void generarDisparo(Personaje enti) {
		Entidad projectil = enti.getProyectil().crearEntidad();
		JLabel lblE, lblP;

		lblE = enti.getEntidadGrafica().getLabelImagen();
		lblP = projectil.getEntidadGrafica().getLabelImagen();

		lblP.setLocation(lblE.getX() + (lblE.getWidth() / 2 - 2), lblE.getY());

		entidades.add(projectil);
		gui.addComponent(lblP);
	}

	public void finalizarJuego() {

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
}
