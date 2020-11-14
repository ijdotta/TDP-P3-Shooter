package logica;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

import entidades.Entidad;
import factories.EntidadFactory;
import factories.jugador.JugadorFactory;
import movimientos.MHorizontal;
import movimientos.Movimiento;
import niveles.Nivel;
import niveles.NivelUno;

public class Juego {
	// Atributos de instancia
	private List<Entidad> entidades;
	private Entidad jugador;
	private Nivel nivel;
	private EntidadFactory factoryJugador;

	// Constructor
	public Juego() {

		entidades = new LinkedList<Entidad>();
		factoryJugador = new JugadorFactory();

		// El primero de la lista es el jugador
		jugador = factoryJugador.crearEntidad();
		jugador.getEntidadGrafica().getLabelImagen().setLocation(350, 475);
		entidades.add(jugador);

		// Inicia el juego desde el nivel uno
		nivel = new NivelUno(this);
		nivel.configurar();

	}

	// Metodos
	public void recibirInput(KeyEvent e) {
		int codigoTecla = e.getKeyCode();

		System.out.print("Tecla ");
		if ((codigoTecla == KeyEvent.VK_LEFT) || (codigoTecla == (KeyEvent.VK_RIGHT))) {
			moverJugador(e);
		} else if (codigoTecla == (KeyEvent.VK_SPACE)) {
			System.out.println("Espacio");
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
}
