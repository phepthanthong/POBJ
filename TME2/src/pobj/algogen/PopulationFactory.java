/**
 * 
 */
package pobj.algogen;

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
			Individu in = new Individu();
			p.add(in);
		}		
		return p;
	}
}
