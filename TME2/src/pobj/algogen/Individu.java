/**
 * 
 */
package pobj.algogen;

import java.util.Random;

/**
 * @author TrungHieu
 *
 */
public class Individu implements Comparable<Individu>{
	private double valeurPropre;	
	private double fitness;
	
	/**
	 * @param newFitness the fitness to set
	 */
	public void setFitness(double newFitness){
		this.fitness = newFitness;
	}
	
	/**
	 * @return the fitness
	 */
	public double getFitness() {
		return fitness;
	}
	
	/**
	 * @return the valeurPropre
	 */
	public double getValeurPropre() {
		return valeurPropre;
	}
	
	/**
	 * Constructeur par d�faut
	 */
	public Individu(){
		Random r = new Random();
		double valeur = r.nextDouble();
		valeurPropre = valeur;
		fitness = 0;
	}
	
	/**
	 * Constructeur avec param�tre
	 * @param val
	 */
	public Individu(double val){
		this.valeurPropre = val;
	}
	
	@Override
	public String toString(){
		return("Valeur propre: " + valeurPropre + "\t Valeur de fitness: " + fitness + "\n" );
	}
	/**
	 * Cette m�thode doit rendre -1, 0 ou 1 selon que l�objet courant est plus petit, �gal ou plus grand que celui pass� en param�tre.
	 */
	@Override
	public int compareTo(Individu o) {
		if (getFitness() > o.getFitness())
			return -1;
		else if (getFitness() < o.getFitness())
			return 1;
		else return 0;
	}
	
	/**
	 * La mutation doit mettre � jour la valeur propre de l�individu de fa�on al�atoire.
	 */
	public void muter(){
		Random r = new Random();
		this.valeurPropre = r.nextDouble();		
	}
	/**
	 * �tant donn� deux individus, le nouvel individu combine une partie des �l�ments du premier avec une partie des �l�ments du second.
	 * @param autre
	 * @return un nouveau individu
	 */
	public Individu croiser(Individu autre){
		Individu newIn = new Individu((getValeurPropre() + autre.getValeurPropre())/2);
		return newIn;
	}
	
	/**
	 * copier les individus d�une population d�origine dans une nouvelle population.
	 */
	public Individu clone() {
		Individu copie = new Individu(this.valeurPropre);
		copie.setFitness(this.fitness);
		return copie;
	}
}
