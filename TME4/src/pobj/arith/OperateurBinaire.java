/**
 * 
 */
package pobj.arith;

/**
 * @author TrungHieu
 *
 */
public class OperateurBinaire implements Expression {
	private final Expression leftChild;
	private final Expression rightChild;
	private final Operator operator;	
	
	/**
	 * @return the operator
	 */
	public Operator getOperator() {
		return operator;
	}
	/**
	 * @return the leftChild
	 */
	public Expression getLeftChild() {
		return leftChild;
	}
	/**
	 * @return the rightChild
	 */
	public Expression getRightChild() {
		return rightChild;
	}	
	
	/**
	 * Constructeur avec paramètres qui initialise un operateur binaire
	 * @param op le type de l'opérande
	 * @param left opérande gauche
	 * @param right opérande droite
	 */
	public OperateurBinaire(Operator op, Expression left, Expression right){
		this.leftChild = left;
		this.rightChild = right;
		this.operator = op;
	}
	
	@Override
	public String toString(){
		return ("(" + getLeftChild().toString() + " "+  getOperator().toString() + " " + getRightChild().toString() + ")");
	}
	
	/* (non-Javadoc)
	 * @see pobj.arith.Expression#eval(pobj.arith.EnvEval)
	 */
	@Override
	public double eval(EnvEval e) {
		switch(operator){
		case PLUS:
			return leftChild.eval(e) + rightChild.eval(e);
		case MINUS:
			return leftChild.eval(e) - rightChild.eval(e);
		case MULT:
			return leftChild.eval(e) * rightChild.eval(e);
		case DIV:
			if (rightChild.eval(e) != 0)
				return leftChild.eval(e) / rightChild.eval(e);
			else {
				System.out.println("L'opérande droite doit être différente de 0 !");
				return 0;
			}
		default:
			break;		
		}
		return 0;
	}

}
