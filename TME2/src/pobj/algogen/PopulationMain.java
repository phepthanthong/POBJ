/**;
 * 
 */
package pobj.algogen;

/**
 * @author TrungHieu
 *
 */
public class PopulationMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Premier argument: " + args[0]);		
		Population pop = PopulationFactory.createRandomPopulation(Integer.parseInt(args[0]));
		System.out.println("Les individus de cette population sont: \n" + pop.toString());
		ValeurCible val = new ValeurCible(0.5);
		pop.evaluer(val);
		System.out.println(pop);
		System.out.println("Après Evolution");
		Population newPop = pop.evoluer(val);
		System.out.println(newPop.toString());
		
	}

}
