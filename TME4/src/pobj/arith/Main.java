/**
 * 
 */
package pobj.arith;

import java.util.Random;

/**
 * @author TrungHieu
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 3;		
		EnvEval env = ExpressionFactory.createRandomEnvironment(5);
		Random r = new Random();
		for (int i = 0; i < size; i++){
			env.setVariables(i, r.nextDouble());
		}
		Expression ex = ExpressionFactory.createRandomExpression(size);
		System.out.println(ex.toString());
		System.out.println(env.toString());
		System.out.println(ex.toString() + " = " + ex.eval(env));		
		
	}

}
