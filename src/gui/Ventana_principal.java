package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Entidad;
import logica.Juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ventana_principal extends JFrame {

	private JPanel escenario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_principal frame = new Ventana_principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana_principal() {
		// Iniciando el juego
		Juego juego = new Juego();
		setTitle("Vertical Shooter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		escenario = new JPanel();
		
		
		escenario.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(escenario);
		escenario.setLayout(null);
		
		// Para reconocer inputs
		agregarListener(this);
		
		// Agregando entidades al escenario
		for(Entidad e: juego.getEntidades())
		{
			this.add(e.getEntidadGrafica().getLabelImagen());
		}
		
	}
	/**
	 * Agrega listener del teclado al frame principal.
	 * @param frame
	 */
	private void agregarListener(JFrame frame)
	{
		frame.addKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e)
			{
				int codigoTecla = e.getKeyCode();

				System.out.print("Tecla ");
				if (codigoTecla == KeyEvent.VK_LEFT)
				{
					System.out.println("Izquierda");
				}
				else if (codigoTecla == (KeyEvent.VK_RIGHT))
				{
					System.out.println("Derecha");
				}
				else if (codigoTecla == (KeyEvent.VK_SPACE))
				{
					System.out.println("Espacio");
				}
				else
				{
					System.out.println();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}
			
		});		
	}
}
