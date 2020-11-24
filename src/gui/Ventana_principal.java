package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.background.Background;
import logica.Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Ventana_principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger logger;

	// private JPanel escenario;
	private JLayeredPane escenario;
	private Timer timer;
	private int refrescoTimer;
	private JLabel lblVidaJugador;
	private JLabel lblStatus;
	private JLabel lblNivel;
	private EntidadGrafica background;
	private KeyListener keyListener;

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
		inicializarLogger();
		
		// Inicio del frame
		setTitle("Vertical Shooter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 639);
		escenario = new JLayeredPane();

		escenario.setBorder(new EmptyBorder(5, 5, 5, 5));		
		setContentPane(escenario);
		escenario.setLayout(null);

		// Inicio del background
		background = new Background(this.getWidth() -16, this.getHeight()-39);
		escenario.add(background.getLabelImagen(), Integer.valueOf(0));

		// Label vida del jugador
		lblVidaJugador = new JLabel("Vida del jugador");
		lblVidaJugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVidaJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidaJugador.setBounds(607, 37, 167, 25);
		escenario.add(lblVidaJugador, Integer.valueOf(3));		
		
		
		lblStatus = new JLabel("Estado del juego");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblStatus.setBounds(150, 100, 500, 200);
		escenario.add(lblStatus, Integer.valueOf(3));
		
		lblNivel = new JLabel("Nivel actual");
		lblNivel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNivel.setBounds(10, 11, 141, 69);
		escenario.add(lblNivel, Integer.valueOf(3));

		// Iniciando el juego
		Juego juego = new Juego(this);

		// Para reconocer inputs
		agregarListener(juego);

		// Muestreo inicial de labels
		lblStatus.setVisible(false);
		
		// Inicializacion del timer
		refrescoTimer = 33; // 30 ticks/segundo
		//refrescoTimer = 16; // 60 ticks/segundo

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
	 * @param j
	 */
	private void agregarListener(Juego j) {
		
		keyListener = new KeyListener() {

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
		};
		
		this.addKeyListener(keyListener);
	}
	/**
	 * remueve el listener actual
	 */
	private void removerListener() {
		this.removeKeyListener(keyListener);
	}
	
	/**
	 * Pone la componente en la capa superior
	 * 
	 * @param comp
	 */
	public void addComponent(JComponent comp) {
		getContentPane().add(comp, Integer.valueOf(2));
	}

	/**
	 * Pone la componente la capa del medio
	 * 
	 * @param comp
	 */
	public void addComponent1(JComponent comp) {
		getContentPane().add(comp, Integer.valueOf(1));
	}
	/**
	 * remueve una componente del escenario
	 * @param comp
	 */
	public void removeComponent(JComponent comp) {		
		// Luego lo quito del escenario
		this.remove(comp);
		// Repintar el background remueve las basuras graficas
		background.getLabelImagen().repaint();
	}

	/**
	 * Actualiza la vida del jugador
	 * @param s
	 */
	public void actualizarLabelVidaJugador(String s) {
		lblVidaJugador.setText(s);
	}

	/**
	 * Cambia la imagen del background segun la ruta 
	 * @param ruta ruta de la imagen
	 */
	public void setBackground(String ruta) {
		background.setImagen(ruta);
	}
	/**
	 * Mostrar que se perdio el juego.
	 * Inhabilitar inputs del teclado
	 */
	public void perderJuego() {
		lblStatus.setForeground(Color.RED);
		lblStatus.setText("Perdiste");
		lblStatus.setVisible(true);
		timer.stop();
		removerListener();
	}
	/**
	 * Mostrar que se gano el juego
	 */
	public void ganarJuego() {
		lblStatus.setForeground(Color.GREEN);
		lblStatus.setText("Ganaste");
		lblStatus.setVisible(true);
		timer.stop();
	}
	
	public void indicarNivel(String nivel_actual) {
		lblNivel.setText(nivel_actual);
	}
	
	public int escenarioWidth() {
		return background.getLabelImagen().getWidth();
	}
	
	public int escenarioHeight() {
		return background.getLabelImagen().getHeight();
	}
	
	private void inicializarLogger() {
		if (logger == null) {
			
			logger = Logger.getLogger(this.getClass().getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.ALL);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.ALL);
			
			Logger rootLoger = logger.getParent();
			for (Handler h : rootLoger.getHandlers())
				h.setLevel(Level.OFF);
		}
	}
}
