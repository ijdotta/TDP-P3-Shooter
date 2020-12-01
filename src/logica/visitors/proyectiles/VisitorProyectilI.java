package logica.visitors.proyectiles;

import logica.entidades.infectados.Alpha;
import logica.entidades.infectados.Beta;
import logica.entidades.jugador.Jugador;
import logica.entidades.premios.EfectoCuarentena;
import logica.entidades.premios.EfectoPocion;
import logica.entidades.premios.EfectoSuperArma;
import logica.entidades.proyectiles.Proyectil_Infectado;
import logica.entidades.proyectiles.Proyectil_Jugador;
import logica.visitors.Visitor;

public class VisitorProyectilI extends Visitor {

	// Atributos de instancia
<<<<<<< HEAD:src/visitors/proyectiles/VisitorProyectilI.java
	private Proyectil_Infectado projectili;

	// Constructor
	public VisitorProyectilI(Proyectil_Infectado pi) {
		projectili = pi;
=======
	private Proyectil_Infectado proyectilInfectado;
	
	// Constructor
	public VisitorProyectilI(Proyectil_Infectado pi)
	{
		proyectilInfectado = pi;
>>>>>>> ac4a7da6769403a542b10f48b109e09bfe369ce2:src/logica/visitors/proyectiles/VisitorProyectilI.java
	}

	// Metodos
	@Override
	public void visitAlpha(Alpha a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitBeta(Beta b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitCuarentena(EfectoCuarentena ec) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitPocion(EfectoPocion ep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitSuperArma(EfectoSuperArma esa) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitProjectilJ(Proyectil_Jugador pj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitProjectilI(Proyectil_Infectado pi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitJugador(Jugador j) {
		j.damage(proyectilInfectado);
		proyectilInfectado.destruir();
	}

}