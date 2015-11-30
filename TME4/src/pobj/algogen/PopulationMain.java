/**;
 * 
 */
package pobj.algogen;

//import pobj.algogen.doubles.ValeurCible;
//import pobj.arith.EnvEval;

/**
 * @author TrungHieu
 *
 */
public class PopulationMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Population pop = PopulationFactory.createRandomPopulation(Integer.parseInt(args[0]));
		//System.out.println("Les individus de cette population sont: \n" + pop.toString());
		//ValeurCible val = new ValeurCible(0.5);
		//Environnement newEnv = PopulationFactory.createEnvironnement();
		pop.evaluer(PopulationFactory.createEnvironnement());
		System.out.println(pop);
		
		Population newPop = pop.evoluer(PopulationFactory.createEnvironnement());
		System.out.println(newPop.toString());
		
	}

}
