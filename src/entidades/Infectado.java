package entidades;

public abstract class Infectado extends Personaje{
	protected int cargaViral;
	protected int dañoMelee;
	
	public Infectado(int cV,int dM) {
		cargaViral=cV;
		dañoMelee=dM;
	}
	
	public int getCargaViral() {
		return cargaViral;
	}
	
	public int getDaño() {
		return dañoMelee;
	}
