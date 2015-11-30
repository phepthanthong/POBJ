/**
 * 
 */
package pobj.algogen.arith;

import pobj.algogen.Environnement;
import pobj.algogen.IIndividu;
import pobj.arith.EnvEval;
import pobj.arith.ExpressionFactory;

/**
 * @author TrungHieu
 *
 */
public class FonctionCible implements Environnement {

	private EnvEval environment;
	private double valeur;
	/**
	 * Constructeur
	 */
	public FonctionCible() {
		valeur = Math.random();
		environment = ExpressionFactory.createRandomEnvironment(10);
	}

	/* (non-Javadoc)
	 * @see pobj.algogen.Environnement#eval(pobj.algogen.IIndividu)
	 */
	@Override
	public double eval(IIndividu i) {
		IndividuExpression in = (IndividuExpression) i;
		return 1/Math.pow(valeur - in.getValeurPropre().eval(environment), 2);
	}

}
