/**
 * 
 */
package pobj.algogen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author TrungHieu
 *
 */
public class Population {
	public List<Individu> individus;
	/**
	 * Constructeur par défaut
	 */
	public Population(){
		individus = new ArrayList<Individu>();
	}
	
	/**
	 * Ajouter un nouveau individu dans une population
	 * @param individu: individu à ajouter
	 */
	public void add(Individu individu){
		individus.add(individu);
	}
	
	@Override
	public String toString(){
		return individus.toString();
	}
	
	/**
	 * Calculer et mettre à jour les fitness de tous les individus par l’appel de la méthode eval() implémentée dans ValeurCible.
	 * @param cible
	 */
	public void evaluer(Environnement cible){
		for (Individu in : individus){			
			in.setFitness(cible.eval(in));			
		}
		Collections.sort(individus);
	}	
	
	/**
	 * fait muter les individus composés dans une population avec une probabilité de prob
	 * @param prob: probabilité à muter
	 */
	public void muter(double prob){
		Random m = new Random();
		for (Individu i : individus.subList(1, individus.size())){
			if (m.nextDouble() < prob)
				i.muter();
		}
	}
	
	/** 
	* Permet de faire évoluer la Population en produisant une nouvelle génération. 
	* La fonction primordiale de la Population est de pouvoir evoluer. 
	* On passe un Environnement qui permettra de calculer le fitness des individus, 
	* afin de décider lesquels sont les plus aptes (survival of the fittest). 
	* On garde ici les 20% meilleurs et on les fait se reproduire pour générer la prochaine génération.
	* @param cible l’objectif/probléme à résoudre/environnement conditionnant l’évolution.
	* @return une nouvelle Population, dont les membres sont tous nouveaux (aucun individu de cette Population n’appartient à la Population "this").
	*/ 
	public Population evoluer (Environnement cible) {
		evaluer(cible);
		Population p = reproduire();
		p.muter(0.05);
		p.evaluer(cible);
		return p;		
	}
	
	/**
	 * créer une nouvelle population à partir de la population courante. En supposant que la population est déjà triée (via évaluer)
		• On crée une nouvelle occurrence de Population pour loger le résultat
		• On y ajoute des clones des 20 % meilleurs individus de la population actuelle.
		• Pour les 80% restant on crée de nouveaux individus en croisant des individus choisis aléatoirement parmi les 20 % meilleurs.
		• Le résultat est une nouvelle Population qui comporte autant d’individus que la précédente.
	 * @return Objet Population
	 */
	private Population reproduire() {
		Random r = new Random();
		int max = individus.size()/5;	
		
		Population p = new Population();		
		for(int i = 0; i < max; i++){
			p.add(individus.get(i).clone());
		}
		
		for (int i = max; i < individus.size(); i++){
			int i1 = r.nextInt(max);
			int i2 = r.nextInt(max);
			Individu in = individus.get(i1).croiser(individus.get(i2));
			//System.out.println(in);
			p.add(in);
		}		
		return p;
	}
}
