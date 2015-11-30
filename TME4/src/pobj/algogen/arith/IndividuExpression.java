/**
 * 
 */
package pobj.algogen.arith;

import pobj.algogen.AbstractIndividu;
import pobj.algogen.IIndividu;
import pobj.arith.Expression;
import pobj.arith.ExpressionFactory;
import pobj.arith.Operator;

/**
 * @author TrungHieu
 *
 */
public class IndividuExpression extends AbstractIndividu {
	private Expression valeurPropreEx;
		
	public IndividuExpression(){
		valeurPropreEx = ExpressionFactory.createRandomExpression();
	}
	public IndividuExpression(Expression e){
		this.valeurPropreEx = e;
	}
	
	@Override
	public Expression getValeurPropre() {
		return valeurPropreEx;
	}

	@Override
	public void muter() {
		valeurPropreEx = ExpressionFactory.createRandomExpression();
	}

	public IndividuExpression croiser(IIndividu autre) {
		IndividuExpression newIn = (IndividuExpression)autre;
		Expression plus = ExpressionFactory.createOperateurBinaire(Operator.PLUS, valeurPropreEx, newIn.getValeurPropre());
		Expression constante = ExpressionFactory.createConstante(2);
		Expression div = ExpressionFactory.createOperateurBinaire(Operator.DIV, plus, constante);
		IndividuExpression e3 = new IndividuExpression(div);
		return e3;
	}

	@Override
	public IndividuExpression clone() {
		IndividuExpression indACloner = new IndividuExpression(this.valeurPropreEx);
		indACloner.setFitness(this.getFitness());
		return indACloner;
	}
	
	public String toString(){
		return("Valeur propre: " + valeurPropreEx + "\t Valeur de fitness: " + fitness + "\n" );
	}

}
