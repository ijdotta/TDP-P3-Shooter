package visitors;

import entidades.infectados.Alpha;
import entidades.infectados.Beta;
import entidades.jugador.Jugador;
import entidades.premios.EfectoCuarentena;
import entidades.premios.EfectoPocion;
import entidades.premios.EfectoSuperArma;
import entidades.proyectiles.Proyectil_Infectado;
import entidades.proyectiles.Proyectil_Jugador;

public abstract class Visitor 
{
	public abstract void visitAlpha(Alpha a);
	public abstract void visitBeta(Beta b);
	public abstract void visitCuarentena(EfectoCuarentena ec);
	public abstract void visitPocion(EfectoPocion ep);
	public abstract void visitSuperArma(EfectoSuperArma esa);
	public abstract void visitProjectilJ(Proyectil_Jugador pj);
	public abstract void visitProjectilI(Proyectil_Infectado pi);
	public abstract void visitJugador(Jugador j);
}
