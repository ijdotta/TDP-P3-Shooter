package logica.entidades.infectados;

import logica.Juego;
import logica.entidades.Personaje;
import logica.entidades.estados.InfectadoDefaultState;
import logica.factories.proyectiles.ProyectilInfectadoFactory;
import logica.movimientos.MVertical;

public abstract class Infectado extends Personaje {
<<<<<<< HEAD:src/entidades/infectados/Infectado.java
	// Atributos de instancia
	protected int damage;
=======
>>>>>>> ac4a7da6769403a542b10f48b109e09bfe369ce2:src/logica/entidades/infectados/Infectado.java

	/**
	 * SUBCLASE DEBE DETERMINAR DMG, VISITOR Y EG
	 * 
	 * @param j
	 * @param eg
	 * @param m
	 * @param v
	 * @param dmg
	 */
	public Infectado(Juego j) {
		super(j);
<<<<<<< HEAD:src/entidades/infectados/Infectado.java

		velocidad = 1;

		movimiento = new MVertical(this, MVertical.DOWN);

=======
		velocidad = 1;
		movimiento = new MVertical(this, MVertical.DOWN);
>>>>>>> ac4a7da6769403a542b10f48b109e09bfe369ce2:src/logica/entidades/infectados/Infectado.java
		state = new InfectadoDefaultState(this);
		proyectil = new ProyectilInfectadoFactory(juego);
	}

	// subí damage a las entidades porque me sirve para el método damage

<<<<<<< HEAD:src/entidades/infectados/Infectado.java
	public void setDamage(int dmg) {
		damage = dmg;
	}

=======
>>>>>>> ac4a7da6769403a542b10f48b109e09bfe369ce2:src/logica/entidades/infectados/Infectado.java
	/**
	 * Si el infectado esta out of bounds me vuelvo a reposicionar
	 */
	public void outOfBounds() {
		if (this.checkOutOfBounds()) {
			juego.reposicionarInfectado(this);
		}
	}

}