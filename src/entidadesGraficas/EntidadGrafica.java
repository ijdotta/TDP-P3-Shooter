package entidadesGraficas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class EntidadGrafica {
	// Atributos de instancia
	protected JLabel labelImagen;

	// Constructor
	public EntidadGrafica(String ruta, int w, int h) {
		labelImagen = new JLabel();
		labelImagen.setSize(w, h);

		ImageIcon imagen = imgRedimensionada(ruta);
		labelImagen.setIcon(imagen);
	}

	// Metodos
	public JLabel getLabelImagen() {
		return labelImagen;
	}

	public void setImagen(String ruta) {
		ImageIcon imagen = imgRedimensionada(ruta);
		labelImagen.setIcon(imagen);
	}

	/**
	 * Devuelve un ImageIcon redimensionado al label actual.
	 * 
	 * @param ruta Ruta de la imagen.
	 * @return ImageIcon redimensionado.
	 */
	public ImageIcon imgRedimensionada(String ruta) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource(ruta));
		ImageIcon imagenRed = new ImageIcon(imagen.getImage().getScaledInstance(labelImagen.getWidth(),
				labelImagen.getHeight(), java.awt.Image.SCALE_SMOOTH));
		return imagenRed;
	}
}