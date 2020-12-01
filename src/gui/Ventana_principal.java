package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import entidadesGraficas.EntidadGrafica;
import entidadesGraficas.background.Background;
import logica.Juego;

public class Ventana_principal extends JFrame {

	private static Logger logger;
	private JLayeredPane escenario;
	private Juego juego;
	private Timer timer;
	private int refrescoTimer;
	private JLabel lblVidaJugador;
	private JLabel lblStatus;
	private JLabel lblNivel;
	private JLabel lblReiniciar;
	private JLabel lblIniciar;
	private EntidadGrafica background;
	private KeyListener keyListener;
	private JLabel lblSiguienteNivel;

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

		// Escenario
		escenario = new JLayeredPane();
		setContentPane(escenario);

		escenario.setBorder(new EmptyBorder(5, 5, 5, 5));
		escenario.setLayout(null);

		// Inicio del background
		background = new Background(this.getWidth() - 16, this.getHeight() - 39);
		escenario.add(background.getLabelImagen(), Integer.valueOf(0));

		// Label vida del jugador
		lblVidaJugador = new JLabel("Vida del jugador");
		lblVidaJugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVidaJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidaJugador.setBounds(607, 37, 167, 25);
		escenario.add(lblVidaJugador, Integer.valueOf(3));

		// Inicio label Status
		lblStatus = new JLabel("Estado del juego");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblStatus.setBounds(150, 100, 500, 200);
		escenario.add(lblStatus, Integer.valueOf(3));

		// Inicio label Nivel
		lblNivel = new JLabel("Nivel actual");
		lblNivel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNivel.setBounds(10, 11, 141, 69);
		escenario.add(lblNivel, Integer.valueOf(3));

		// Inicio label Iniciar
		lblIniciar = new JLabel("Iniciar");
		this.agregarListenerIniciar();
		lblIniciar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciar.setBounds(241, 200, 292, 87);
		lblIniciar.setVisible(true);
		escenario.add(lblIniciar, Integer.valueOf(5));

		// Inicio label Reiniciar
		lblReiniciar = new JLabel("Reiniciar");
		this.agregarListenerReiniciar();
		lblReiniciar.setHorizontalAlignment(SwingConstants.CENTER);
		lblReiniciar.setBounds(241, 200, 292, 87);
		lblReiniciar.setVisible(false);
		escenario.add(lblReiniciar, Integer.valueOf(5));
		
		// Inicio siguiente nivel
		lblSiguienteNivel = new JLabel("Siguiente Nivel");
		this.agregarListenerSigNivel();
		lblSiguienteNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiguienteNivel.setBounds(241, 200, 292, 87);
		lblSiguienteNivel.setVisible(false);
		escenario.add(lblSiguienteNivel, Integer.valueOf(5));

		// Inicializar juego
		juego = new Juego(this);

		// Para reconocer inputs
		this.agregarListener();

		// Muestreo inicial de labels
		lblStatus.setVisible(true);
		lblNivel.setText("Menu");
		lblStatus.setText("Vertical Shooter");

		// Inicializacion del timer
		iniciarTimer();
	}

	private void iniciarTimer() {
		//Creo el timer
		refrescoTimer = 33; // 30 ticks/segundo
		// refrescoTimer = 16; // 60 ticks/segundo

		timer = new Timer(refrescoTimer, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				juego.accionar();
			}
		});

		timer.start();		
	}

	private void agregarListenerSigNivel() {
		lblSiguienteNivel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSiguienteNivel.setVisible(false);
				lblStatus.setVisible(false);
				juego.iniciarNivel();
				iniciarTimer();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSiguienteNivel.setForeground(Color.yellow);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSiguienteNivel.setForeground(Color.black);
			}
		});
		
	}

	private void agregarListenerIniciar() {
		lblIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblIniciar.setVisible(false);
				lblStatus.setVisible(false);
				juego.iniciarNivel();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblIniciar.setForeground(Color.yellow);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblIniciar.setForeground(Color.black);
			}
		});
	}

	private void agregarListenerReiniciar() {
		lblReiniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblReiniciar.setVisible(false);
				lblIniciar.setVisible(true);
				lblNivel.setText("Menu");
				background.setImagen("/img/background_Scenery43.png");
				lblStatus.setForeground(Color.BLACK);
				lblStatus.setText("Vertical Shooter");

				juego.reiniciarJuego();
				agregarListener();
				timer.start();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblReiniciar.setForeground(Color.yellow);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblReiniciar.setForeground(Color.black);
			}
		});
	}

	/**
	 * Agrega listener del teclado al frame principal.
	 * 
	 * @param j
	 */
	private void agregarListener() {
		keyListener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				juego.recibirInput(e);
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
	 * 
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
	 * 
	 * @param s
	 */
	public void actualizarLabelVidaJugador(String s) {
		lblVidaJugador.setText(s);
	}

	/**
	 * Cambia la imagen del background segun la ruta
	 * 
	 * @param ruta ruta de la imagen
	 */
	public void setBackground(String ruta) {
		background.setImagen(ruta);
	}

	/**
	 * Mostrar que se perdio el juego. Inhabilitar inputs del teclado
	 */
	public void perderJuego() {
		lblStatus.setForeground(Color.RED);
		lblStatus.setText("Perdiste");
		lblStatus.setVisible(true);
		timer.stop();
		removerListener();
		lblReiniciar.setVisible(true);
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
	
	public void siguienteNivel() {
		this.lblSiguienteNivel.setVisible(true);
		
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
