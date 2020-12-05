package logica.visitors;

import logica.entidades.infectados.Alpha;
import logica.entidades.infectados.Beta;
import logica.entidades.jugador.Jugador;
import logica.entidades.premios.EfectoCuarentena;
import logica.entidades.premios.EfectoPocion;
import logica.entidades.premios.EfectoSuperArma;
import logica.entidades.proyectiles.Proyectil_Infectado;
import logica.entidades.proyectiles.Proyectil_Jugador;

public interface Visitor {
	public void visitAlpha(Alpha a);

	public void visitBeta(Beta b);

	public void visitCuarentena(EfectoCuarentena ec);

	public void visitPocion(EfectoPocion ep);

	public void visitSuperArma(EfectoSuperArma esa);

	public void visitProjectilJ(Proyectil_Jugador pj);

	public void visitProjectilI(Proyectil_Infectado pi);

	public void visitJugador(Jugador j);
}
