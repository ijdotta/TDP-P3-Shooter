package logica.entidades.estados;

/**
 * Interface State define de los comportamientos generales de una entidad.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
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
	 * <<<<<<< HEAD:src/entidades/estados/State.java Estoy pensando que
	 * CongeladoState podr�a ser una subclase de DefaultState para que redefina solo
	 * lo que tiene que redefinir. ======= Estoy pensando que CongeladoState podr�a
	 * ser una subclase de DefaultState para que redefina solo lo que tiene que
	 * redefinir. >>>>>>>
	 * ac4a7da6769403a542b10f48b109e09bfe369ce2:src/logica/entidades/estados/State.
	 * java
	 */

	/**
	 * Implementacion de que hace una entidad al disparar
	 */
	public void disparar();
	/**
	 * Implementacion de que hace una entidad al morir
	 */
	public void morir();
	/**
	 * Implementacion de que hace una entidad al moverse
	 */
	public void mover();

}
