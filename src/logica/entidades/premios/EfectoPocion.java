package logica.entidades.premios;

import logica.Juego;
import logica.entidadesGraficas.premios.GraficoPocion;
import logica.visitors.Visitor;
import logica.visitors.premios.VisitorPocion;
/**
 * Class EfectoPocionImplementacion de un premio pocion.
 * 
 * @author Comision 12
 * @author Agustin Emanuel Gonzalez Diaz
 * @author Ignacio Joaquin Dotta
 * @author Steffano Miguel Pitto
 */
public class EfectoPocion extends EfectoPermanente {

	// Atributos de instancia
	public static final int CURACION = 25;

	// Constructor
	/**
	 * Inicia el premio cuarentena con 5 de velocidad, su sprite grafico y su visitor.
	 * @param j juego a conocer
	 */
	public EfectoPocion(Juego j) {
		super(j);

		velocidad = 5;
		entidadGrafica = new GraficoPocion(30, 30);

		visitor = new VisitorPocion(this);
	}

	// Metodos
	@Override
	public void accept(Visitor v) {
		v.visitPocion(this);
	}

}
