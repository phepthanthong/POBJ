/**
 * 
 */
package pobj.algogen.arith;

import pobj.algogen.AbstractIndividu;
import pobj.algogen.IIndividu;
import pobj.arith.Expression;
import pobj.arith.ExpressionFactory;

/**
 * @author TrungHieu
 *
 */
public class IndividuExpression extends AbstractIndividu {
	private Expression valeurPropreEx;
	
	public IndividuExpression(){
		valeurPropreEx = new ExpressionFactory.createRandomExpression();
	}
	
	@Override
	public Expression getValeurPropre() {
		return valeurPropreEx;
	}

	
	public void muter() {
		valeurPropreEx = new ExpressionFactory.createRandomExpression();
	}

	public IndividuExpression croiser(IndividuExpression autre) {
		return null;
	}

	@Override
	public IIndividu clone() {
		return null;
	}

}
