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

import logica.Juego;
import logica.entidadesGraficas.EntidadGrafica;
import logica.entidadesGraficas.background.Background;

/**
 * Class Ventana_principal Implementacion de la parte grafica y gui del juego.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class Ventana_principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
		// Iniciar de Logger
		inicializarLogger();

		// Inicio del frame
		setTitle("Pâtisserie Nightmare");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 639);
		setResizable(false);

		// Escenario
		escenario = new JLayeredPane();
		setContentPane(escenario);
		escenario.setBorder(new EmptyBorder(5, 5, 5, 5));
		escenario.setLayout(null);

		// Inicio del background
		// se restan pixeles para que se muestre correctamente la imagen dentro del
		// frame
		background = new Background(this.getWidth() - 16, this.getHeight() - 39);
		escenario.add(background.getLabelImagen(), Integer.valueOf(0));
		
		//Colores
		Color lbl_txt_color = Color.WHITE;

		// Label vida del jugador
		lblVidaJugador = new JLabel("Vida del jugador");
		lblVidaJugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVidaJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidaJugador.setBounds(607, 37, 167, 25);
		lblVidaJugador.setForeground(lbl_txt_color);
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
		lblNivel.setForeground(lbl_txt_color);
		escenario.add(lblNivel, Integer.valueOf(3));

		// Inicio label Iniciar
		lblIniciar = new JLabel("Iniciar");
		this.agregarListenerIniciar();
		lblIniciar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciar.setBounds(241, 200, 292, 87);
		lblIniciar.setVisible(true);
		lblIniciar.setForeground(Color.BLACK);
		escenario.add(lblIniciar, Integer.valueOf(5));

		// Inicio label Reiniciar
		lblReiniciar = new JLabel("Reiniciar");
		this.agregarListenerReiniciar();
		lblReiniciar.setHorizontalAlignment(SwingConstants.CENTER);
		lblReiniciar.setBounds(241, 200, 292, 87);
		lblReiniciar.setVisible(false);
		escenario.add(lblReiniciar, Integer.valueOf(5));

		// Inicializar juego
		juego = new Juego(this);

		// Para reconocer inputs
		this.agregarListener();

		// Muestreo inicial de labels
		lblStatus.setVisible(true);
		lblNivel.setText("Menu");
		lblStatus.setText("Pâtisserie Nightmare");
		lblStatus.setForeground(Color.BLACK);

		// Inicializacion del timer
		refrescoTimer = 33; // 30 ticks/segundo

		timer = new Timer(refrescoTimer, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				juego.accionar();
			}
		});

		timer.start();
	}

	/**
	 * Agrega comportamientos al label Iniciar para simular un boton.
	 */
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
				lblIniciar.setForeground(Color.GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblIniciar.setForeground(Color.BLACK);
			}
		});
	}

	/**
	 * Agrega comportamientos al label Reiniciar para simular un boton.
	 */
	private void agregarListenerReiniciar() {
		lblReiniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblReiniciar.setVisible(false);
				lblIniciar.setVisible(true);
				lblNivel.setText("Menu");
				background.setImagen("/img/background_Scenery43.png");
				lblStatus.setForeground(Color.BLACK);
				lblStatus.setText("Pâtisserie Nightmare");

				juego.reiniciarJuego();
				agregarListener();
				timer.start();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblReiniciar.setForeground(Color.GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblReiniciar.setForeground(Color.BLACK);
			}
		});
	}

	/**
	 * Agrega listener del teclado al frame principal, envia los inputs a la parte
	 * logica del juego.
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
	 * remueve el listener actual, el usuario no pueda seguir utilizando el teclado.
	 */
	private void removerListener() {
		this.removeKeyListener(keyListener);
	}

	/**
	 * Pone la componente en la capa superior
	 * 
	 * @param comp componente a agregar
	 */
	public void addComponent(JComponent comp) {
		getContentPane().add(comp, Integer.valueOf(2));
	}

	/**
	 * Pone la componente la capa del medio
	 * 
	 * @param comp componente a agregar
	 */
	public void addComponent1(JComponent comp) {
		getContentPane().add(comp, Integer.valueOf(1));
	}

	/**
	 * remueve una componente del escenario
	 * 
	 * @param comp componente a agregar
	 */
	public void removeComponent(JComponent comp) {
		// sacar del escenario el label
		this.remove(comp);
		// Repintar el background remueve las basuras graficas
		background.getLabelImagen().repaint();
	}

	/**
	 * Actualiza la vida del jugador en display
	 * 
	 * @param s texto indicando la vida del jugador
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
	 * Mostrar que se perdio el juego. Inhabilita inputs del teclado
	 */
	public void perderJuego() {
		// Muestra en rojo que se perdio
		lblStatus.setForeground(Color.RED);
		lblStatus.setText("Perdiste");
		lblStatus.setVisible(true);
		// Se frena el juego
		timer.stop();
		// Se inhabilita el teclado
		removerListener();
		// Se da la opcion de reiniciar
		lblReiniciar.setVisible(true);
	}

	/**
	 * Mostrar que se ganó el juego
	 */
	public void ganarJuego() {
		// Muestra que se ganó.
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setText("¡Ganaste!");
		lblStatus.setVisible(true);
		
		// Se frena el juego
		timer.stop();
		
		// Se inhabilita el teclado
		removerListener();

		// Se da la opcion de reiniciar
		lblReiniciar.setVisible(true);
	}

	/**
	 * Actualiza el nivel en display.
	 * 
	 * @param nivel_actual texto indicando el nivel actual
	 */
	public void indicarNivel(String nivel_actual) {
		lblNivel.setText(nivel_actual);
	}

	/**
	 * Retorna el ancho del escenario
	 * 
	 * @return ancho del escenario
	 */
	public int escenarioWidth() {
		return background.getLabelImagen().getWidth();
	}

	/**
	 * Retorna el alto del escenario
	 * 
	 * @return alto del escenario
	 */
	public int escenarioHeight() {
		return background.getLabelImagen().getHeight();
	}

	/**
	 * Inicializá el logger.
	 */
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
