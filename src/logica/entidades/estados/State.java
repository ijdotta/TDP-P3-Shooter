package logica.entidades.estados;

public interface State {

	/*
	 * Lo hago como interface porque as� lo propone el cat�logo de patrones Si
	 * quisieramos hacer lo de que el estado determine la imagen del personaje hay
	 * dos opciones:
	 * 
	 * 1. Hacer State una clase abstracta en vez de interface para que pueda conocer
	 * la entidad y hacer entidad.getEntidadGrafica().setImage(...)
	 * 
	 * 2. Agregar un m�todo getImage() : Image (o URL) y luego entidad tiene un
	 * updateImage que usa esa imagen que recibi�
	 */
	
	/*
	 * Estoy pensando que CongeladoState podr�a ser una subclase de DefaultState para que redefina solo lo que tiene que redefinir.
	 */

	public void disparar();

	public void morir();
	
	public void mover();

}
