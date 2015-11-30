/**
 * 
 */
package pobj.algogen.doubles;

import java.util.Random;

import pobj.algogen.AbstractIndividu;
import pobj.algogen.IIndividu;

/**
 * @author TrungHieu
 *
 */
public class IndividuDouble extends AbstractIndividu {
	double valeurPropre;	
	/* (non-Javadoc)
	 * @see pobj.algogen.IIndividu#getValeurPropre()
	 */
	@Override
	public Object getValeurPropre() {
		return valeurPropre;
	}
	
	/**
	 * Constructeur par défaut
	 */
	public IndividuDouble(){
		Random r = new Random();
		double valeur = r.nextDouble();
		valeurPropre = valeur;
		fitness = 0;
	}
	
	/**
	 * Constructeur avec paramètre
	 * @param val
	 */
	public IndividuDouble(double val){
		this.valeurPropre = val;
	}
	
	@Override
	public String toString(){
		return("Valeur propre: " + valeurPropre + "\t Valeur de fitness: " + fitness + "\n" );
	}

	@Override
	public IndividuDouble clone() {
		IndividuDouble copie = new IndividuDouble(this.valeurPropre);
		copie.setFitness(this.fitness);
		return copie;
	}

	@Override
	public void muter() {
		Random r = new Random();
		this.valeurPropre = r.nextDouble();			
	}

	@Override
	public IndividuDouble croiser(IIndividu autre) {
		IndividuDouble newIn = new IndividuDouble ((valeurPropre + (double)autre.getValeurPropre())/2);
		return newIn;
	}
}
