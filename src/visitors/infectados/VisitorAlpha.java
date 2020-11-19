package visitors.infectados;

import entidades.infectados.Alpha;
import entidades.infectados.Beta;
import entidades.jugador.Jugador;
import entidades.premios.EfectoCuarentena;
import entidades.premios.EfectoPocion;
import entidades.premios.EfectoSuperArma;
import entidades.proyectiles.Proyectil_Infectado;
import entidades.proyectiles.Proyectil_Jugador;
import visitors.Visitor;

public class VisitorAlpha extends Visitor {

	// Atributos de instancia
	private Alpha alpha;

	// Constructor
	public VisitorAlpha(Alpha a) {
		alpha = a;
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
		j.setVida(j.getVida() - alpha.getDamage());
		
		// Actualizar graficamente la vida
		j.getJuego().getGui().actualizarLabelVidaJugador("Vida_Jugador: "+j.getVida());
	}
}
