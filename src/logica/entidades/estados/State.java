package logica.entidades.estados;

public interface State {

	/*
	 * Lo hago como interface porque asï¿½ lo propone el catï¿½logo de patrones Si
	 * quisieramos hacer lo de que el estado determine la imagen del personaje hay
	 * dos opciones:
	 * 
	 * 1. Hacer State una clase abstracta en vez de interface para que pueda conocer
	 * la entidad y hacer entidad.getEntidadGrafica().setImage(...)
	 * 
	 * 2. Agregar un mï¿½todo getImage() : Image (o URL) y luego entidad tiene un
	 * updateImage que usa esa imagen que recibiï¿½
	 */

	/*
<<<<<<< HEAD:src/entidades/estados/State.java
	 * Estoy pensando que CongeladoState podría ser una subclase de DefaultState
	 * para que redefina solo lo que tiene que redefinir.
=======
	 * Estoy pensando que CongeladoState podrï¿½a ser una subclase de DefaultState para que redefina solo lo que tiene que redefinir.
>>>>>>> ac4a7da6769403a542b10f48b109e09bfe369ce2:src/logica/entidades/estados/State.java
	 */

	public void disparar();

	public void morir();

	public void mover();

}
