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

public class VisitorProyectilJ extends Visitor {

	// Atributos de instancia
<<<<<<< HEAD:src/visitors/proyectiles/VisitorProyectilJ.java
	private Proyectil_Jugador projectilj;

	// Constructor
	public VisitorProyectilJ(Proyectil_Jugador pj) {
		projectilj = pj;
=======
	private Proyectil_Jugador proyectilJugador;
	
	// Constructor
	public VisitorProyectilJ(Proyectil_Jugador pj)
	{
		proyectilJugador = pj;
>>>>>>> ac4a7da6769403a542b10f48b109e09bfe369ce2:src/logica/visitors/proyectiles/VisitorProyectilJ.java
	}

	// Metodos
	@Override
	public void visitAlpha(Alpha a) {
<<<<<<< HEAD:src/visitors/proyectiles/VisitorProyectilJ.java
		// Hacerle daño
		a.setVida(a.getVida() - projectilj.getDamage());
		// Matar el projectil
		projectilj.setVida(-1);

		if (a.getVida() <= 0) {
			System.out.println("MUERTO: " + a.toString() + "   HP: " + a.getVida());
		}
=======
		a.damage(proyectilJugador);
		proyectilJugador.destruir();
>>>>>>> ac4a7da6769403a542b10f48b109e09bfe369ce2:src/logica/visitors/proyectiles/VisitorProyectilJ.java
	}

	@Override
	public void visitBeta(Beta b) {
<<<<<<< HEAD:src/visitors/proyectiles/VisitorProyectilJ.java
		b.setVida(b.getVida() - projectilj.getDamage());

		if (b.getVida() <= 0) {
			System.out.println("MUERTO: " + b.toString());
		}
=======
		b.damage(proyectilJugador);
		proyectilJugador.destruir();
>>>>>>> ac4a7da6769403a542b10f48b109e09bfe369ce2:src/logica/visitors/proyectiles/VisitorProyectilJ.java
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
		// TODO Auto-generated method stub

	}

}
