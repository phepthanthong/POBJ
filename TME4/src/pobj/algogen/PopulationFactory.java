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
	 * Op�ration permettant d�obtenir une nouvelle population g�n�r�e al�atoirement. 
	 * @param size la taille de la population � cr�er
	 * @return une population compos�e de "size" individus g�n�r�s al�atoirement.
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
