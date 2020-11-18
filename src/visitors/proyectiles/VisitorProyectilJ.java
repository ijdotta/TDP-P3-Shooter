package visitors.proyectiles;

import entidades.infectados.Alpha;
import entidades.infectados.Beta;
import entidades.jugador.Jugador;
import entidades.premios.EfectoCuarentena;
import entidades.premios.EfectoPocion;
import entidades.premios.EfectoSuperArma;
import entidades.proyectiles.Proyectil_Infectado;
import entidades.proyectiles.Proyectil_Jugador;
import visitors.Visitor;

public class VisitorProyectilJ extends Visitor{
	
	// Atributos de instancia
	private Proyectil_Jugador projectilj;
	
	// Constructor
	public VisitorProyectilJ(Proyectil_Jugador pj)
	{
		projectilj = pj;
	}
	
	// Metodos	
	@Override
	public void visitAlpha(Alpha a) {
		// Hacerle daño
		a.setVida(a.getVida() - projectilj.getDamage());
		// Matar el projectil
		projectilj.setVida(-1);
		
		if(a.getVida() <= 0)
		{
			System.out.println("MUERTO: "+a.toString()+"   HP: "+a.getVida());
		}
	}

	@Override
	public void visitBeta(Beta b) {
		b.setVida(b.getVida() - projectilj.getDamage());
		
		if(b.getVida() <= 0)
		{
			System.out.println("MUERTO: "+b.toString());
		}
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
