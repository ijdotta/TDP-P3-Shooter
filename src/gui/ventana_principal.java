package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ventana_principal extends JFrame{

	private JPanel escenario;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana_principal frame = new ventana_principal();
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
	public ventana_principal() {		
		// Reconocer inputs global
		/**
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new KeyEventDispatcher()
		{
			@Override
			public boolean dispatchKeyEvent(KeyEvent e)
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

				return true;
			}			
		});
		**/
		
		setTitle("Vertical Shooter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		escenario = new JPanel();
		
		
		escenario.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(escenario);
		escenario.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(142, 146, 83, 26);
		escenario.add(lblNewLabel);
		// Para reconocer inputs
		agregarListener(this);
		
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
