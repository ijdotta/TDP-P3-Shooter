package logica.visitors;

import logica.entidades.infectados.Alpha;
import logica.entidades.infectados.Beta;
import logica.entidades.jugador.Jugador;
import logica.entidades.premios.EfectoCuarentena;
import logica.entidades.premios.EfectoPocion;
import logica.entidades.premios.EfectoSuperArma;
import logica.entidades.proyectiles.Proyectil_Infectado;
import logica.entidades.proyectiles.Proyectil_Jugador;

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
