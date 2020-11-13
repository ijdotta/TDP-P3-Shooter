package logica;

import java.util.List;

import entidades.Entidad;
import niveles.Nivel;

public class Juego {
	
	private List<Entidad> entidades;
	private Nivel nivel;

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
