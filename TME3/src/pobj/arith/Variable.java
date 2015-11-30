/**
 * 
 */
package pobj.arith;

/**
 * @author TrungHieu
 *
 */
public class Variable implements Expression {
	private final int rangDeVariable;
	
	/**
	 * Constructeur avec paramètre qui initialise le rang d'une variable
	 * @param rang le rang de la variable
	 */
	public Variable(int rang){
		this.rangDeVariable = rang;
	}
	/* (non-Javadoc)
	 * @see pobj.arith.Expression#eval(pobj.arith.EnvEval)
	 */
	@Override
	public double eval(EnvEval e) {
		return e.getValue(this.rangDeVariable);
	}

	@Override
	public String toString(){
		return ("X" + rangDeVariable);
	}
}
