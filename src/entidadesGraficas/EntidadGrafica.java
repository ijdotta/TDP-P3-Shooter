package entidadesGraficas;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class EntidadGrafica {
	// Atributos de instancia
	protected JLabel labelImagen;
	
	// Constructor
	public EntidadGrafica(String ruta)
	{
		
	}
	//Metodos
	public JLabel getLabelImagen() {
		return labelImagen;
	}
	
	public void setImagen(String ruta)
	{
		
	}
	/**
	 * Devuelve un ImageIcon redimensionado al label actual.
	 * @param ruta Ruta de la imagen.
	 * @return ImageIcon redimensionado.
	 */
	public ImageIcon imgRedimensionada(String ruta) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource(ruta));
		ImageIcon imagenRed = new ImageIcon(imagen.getImage().getScaledInstance(labelImagen.getX(), labelImagen.getY(),java.awt.Image.SCALE_SMOOTH));
		return imagenRed;
	}
}