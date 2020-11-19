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

public class VisitorProyectilI extends Visitor{

	// Atributos de instancia
	private Proyectil_Infectado projectili;
	
	// Constructor
	public VisitorProyectilI(Proyectil_Infectado pi)
	{
		projectili = pi;
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
		// Hacer daño
		j.setVida(j.getVida() - projectili.getDamage());
		// Matar el projectil
		projectili.setVida(-1);
		
		// Actualizar graficamente la vida
		j.getJuego().getGui().actualizarLabelVidaJugador("Vida_Jugador: "+j.getVida());
	}

}
