/**
 * 
 */
package pobj.algogen;

import pobj.algogen.arith.FonctionCible;
import pobj.algogen.arith.IndividuExpression;

/**
 * @author TrungHieu
 *
 */
public class PopulationFactory {
	
	public PopulationFactory(){
		
	}
	/**
	 * Opération permettant d’obtenir une nouvelle population générée aléatoirement. 
	 * @param size la taille de la population à créer
	 * @return une population composée de "size" individus générés aléatoirement.
	 */
	public static Population createRandomPopulation(int size){
		//PopulationArray p = new PopulationArray();
		Population p = new Population();
		for (int i = 0; i < size; i++ ){
			IndividuExpression in = new IndividuExpression();
			p.add(in);
		}		
		return p;
	}
	
	public static Environnement createEnvironnement(){
		return new FonctionCible();
	}
}
