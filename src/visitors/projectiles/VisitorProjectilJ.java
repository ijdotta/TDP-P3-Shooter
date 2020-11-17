package visitors.projectiles;

import entidades.infectados.Alpha;
import entidades.infectados.Beta;
import entidades.jugador.Jugador;
import entidades.premios.EfectoCuarentena;
import entidades.premios.EfectoPocion;
import entidades.premios.EfectoSuperArma;
import entidades.proyectiles.Proyectil_Infectado;
import entidades.proyectiles.Proyectil_Jugador;
import visitors.Visitor;

public class VisitorProjectilJ extends Visitor{
	
	// Atributos de instancia
	private Proyectil_Jugador projectilj;
	
	// Constructor
	public VisitorProjectilJ(Proyectil_Jugador pj)
	{
		projectilj = pj;
	}
	
	// Metodos	
	@Override
	public void visitAlpha(Alpha a) {
		a.setHP(a.getHP() - projectilj.getDamage());
		
		if(a.getHP() <= 0)
		{
			System.out.println("MUERTO: "+a.toString()+"   HP: "+a.getHP());
		}
	}

	@Override
	public void visitBeta(Beta b) {
		b.setHP(b.getHP() - projectilj.getDamage());
		
		if(b.getHP() <= 0)
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
