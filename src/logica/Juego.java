package logica;

import java.util.LinkedList;
import java.util.List;

import entidades.Entidad;
import factories.EntidadFactory;
import factories.jugador.JugadorFactory;
import niveles.Nivel;
import niveles.NivelUno;

public class Juego {
	
	private List<Entidad> entidades;
	private Nivel nivel;
	private EntidadFactory factoryJugador;
	public Juego()
	{
		
		entidades = new LinkedList<Entidad>();
		factoryJugador = new JugadorFactory();
		
		// El primero de la lista es el jugador
		Entidad jugador = factoryJugador.crearEntidad();
		jugador.getEntidadGrafica().getLabelImagen().setLocation(350, 475);
		entidades.add(jugador);
		
		// Inicia el juego desde el nivel uno
		nivel = new NivelUno(this);
		nivel.configurar();
		
	}
	public void recibirInput() {

	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public void finalizarJuego() {
		
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public List<Entidad> getEntidades() {
		return entidades;
	}
}
