package entidades;

public abstract class Infectado extends Personaje{
	protected int cargaViral;
	protected int da�oMelee;
	
	public Infectado(int cV,int dM) {
		cargaViral=cV;
		da�oMelee=dM;
	}
	
	public int getCargaViral() {
		return cargaViral;
	}
	
	public int getDa�o() {
		return da�oMelee;
	}
