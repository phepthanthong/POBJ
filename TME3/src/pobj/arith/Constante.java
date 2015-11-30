/**
 * 
 */
package pobj.arith;

/**
 * @author TrungHieu
 *
 */
public class Constante implements Expression {
	private final double uneConstante;
	
	/**
	 * @return the uneConstante
	 */
	public double getUneConstante() {
		return uneConstante;
	}
	/**
	 * Constructeur avec paramètre qui initialise une constante
	 * @param cons la constante
	 */
	public Constante(double cons){
		this.uneConstante = cons;
	}
	/* (non-Javadoc)
	 * @see pobj.arith.Expression#eval(pobj.arith.EnvEval)
	 */
	@Override
	public double eval(EnvEval e) {
		return this.uneConstante;
	}

	@Override
	public String toString(){
		return ""+ uneConstante;
	}
}
