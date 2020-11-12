package entidades;

public abstract class Personaje  extends Entidad{
	protected int cargaViral; //Esto se podría sacar ya que El infectado hace "Daño" y el Jugador "Cura". Se podría definir "Carga Viral" en Infectado y Daño en Jugador
	protected int velocidadMov;
	
	public int getCargaViral() {
		return cargaViral;
	}
	
	
	
	
}
