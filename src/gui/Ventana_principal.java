package gui;

import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import logica.Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Ventana_principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private JPanel escenario;
	private JLayeredPane escenario;
	private Timer timer;
	private int refrescoTimer;
	JLabel lblVidaJugador;

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
		// Inicio del frame
		setTitle("Vertical Shooter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		escenario = new JLayeredPane();

		escenario.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(escenario);
		escenario.setLayout(null);

		// Label vida del jugador
		lblVidaJugador = new JLabel("N/A");
		lblVidaJugador.setBounds(330, 525, 132, 25);
		escenario.add(lblVidaJugador);

		// Iniciando el juego
		Juego juego = new Juego(this);

		// Para reconocer inputs
		agregarListener(juego);

		// Inicializacion del timer
		refrescoTimer = 50;

		timer = new Timer(refrescoTimer, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				juego.accionar();
			}
		});

		timer.start();
	}

	/**
	 * Agrega listener del teclado al frame principal.
	 * 
	 * @param frame
	 */
	private void agregarListener(Juego j) {
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				j.recibirInput(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

		});
	}

	public void addComponent(JComponent comp) {
		getContentPane().add(comp, 2);
	}
	
	public void addComponent1(JComponent comp) {
		getContentPane().add(comp, 10);
	}

	public void removeComponent(JComponent comp) {
		this.remove(comp);
	}

	public void actualizarLabelVidaJugador(String s) {
		lblVidaJugador.setText(s);
	}

	public void setBackground(JComponent bg) {
		escenario.add(bg, 6);
	}
}
