package logica.entidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Abstract Class EntidadGrafica Implementacion y definicion de los
 * comportamientos generales de la parte grafica de una entidad.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public abstract class EntidadGrafica {
	// Atributos de instancia
	protected JLabel labelImagen;
	protected String ruta;

	// Constructor
	/**
	 * Inicia la entidad grafica con una imagen y dimensiones pasadas por parametro
	 * 
	 * @param ruta ruta de la imagen
	 * @param w    ancho
	 * @param h    alto
	 */
	public EntidadGrafica(String ruta, int w, int h) {
		labelImagen = new JLabel();
		labelImagen.setSize(w, h);
		this.ruta = ruta;
		redimensionarImagen();
	}

	// Metodos
	/**
	 * Setea la imagen de la entidad grafica segun una ruta.
	 * 
	 * @param ruta ruta de la imagen.
	 */
	public void setImagen(String ruta) {
		this.ruta = ruta;
		redimensionarImagen();
	}

	/**
	 * Redimensiona la imagen actual para que se ajuste a las dimensiones del label.
	 */
	private void redimensionarImagen() {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource(ruta));
		ImageIcon imagenRed = new ImageIcon(imagen.getImage().getScaledInstance(labelImagen.getWidth(),
				labelImagen.getHeight(), java.awt.Image.SCALE_SMOOTH));
		labelImagen.setIcon(imagenRed);
	}

	// Getters/ Setters
	/**
	 * Retorna el JLabel de la entidad grafica.
	 * 
	 * @return JLabel de la entidad grafica.
	 */
	public JLabel getLabelImagen() {
		return labelImagen;
	}

	/**
	 * Retorna el ancho del label.
	 * 
	 * @return ancho del label.
	 */
	public int getWidth() {
		return labelImagen.getWidth();
	}

	/**
	 * Retorna la altura del label
	 * 
	 * @return altura del label
	 */
	public int getHeight() {
		return labelImagen.getHeight();
	}

	/**
	 * setea el ancho y alto del label
	 * 
	 * @param w ancho
	 * @param h alto
	 */
	public void setSize(int w, int h) {
		labelImagen.setSize(w, h);
		redimensionarImagen();
	}

	/**
	 * Retorna la posicion del label en el eje x
	 * 
	 * @return posicion del label en el eje x
	 */
	public int getX() {
		return labelImagen.getX();
	}

	/**
	 * Retorna la posicion del label en el eje y
	 * 
	 * @return posicion del label en el eje y
	 */
	public int getY() {
		return labelImagen.getY();
	}

	/**
	 * Setea la posicion del label segun los ejes coordenados
	 * 
	 * @param x posicion del label en el eje x
	 * @param y posicion del label en el eje y
	 */
	public void setLocation(int x, int y) {
		labelImagen.setLocation(x, y);
	}
}