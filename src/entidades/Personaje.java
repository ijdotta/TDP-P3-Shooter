package entidades;

public abstract class Personaje  extends Entidad{
	protected int cargaViral; //Esto se podr�a sacar ya que El infectado hace "Da�o" y el Jugador "Cura". Se podr�a definir "Carga Viral" en Infectado y Da�o en Jugador
	protected int velocidadMov;
	
	public int getCargaViral() {
		return cargaViral;
	}
	
	
	
	
}
