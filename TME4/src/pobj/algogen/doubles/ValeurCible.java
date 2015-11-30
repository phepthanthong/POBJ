/**
 * 
 */
package pobj.algogen.doubles;

import java.util.Random;

import pobj.algogen.Environnement;
import pobj.algogen.IIndividu;

/**
 * @author TrungHieu
 *
 */
public class ValeurCible implements Environnement {
	private double valeur;
	/* (non-Javadoc)
	 * @see pobj.algogen.Environnement#eval(pobj.algogen.Individu)
	 */
	/**
	 * @return the valeur: retourner l'attribut valeur de la classe
	 */
	public double getValeur() {
		return this.valeur;
	}
	
	/**
	 * Constructeur par défaut
	 */
	public ValeurCible(){}
	
	/**
	 * Constructeur avec paramètre
	 * @param val
	 */
	public ValeurCible(double val){
		Random m = new Random();
		val = m.nextDouble();
		this.valeur = val;
	}
	
	/**
	 * rendre la fitness de l’individu « i » dans l’environnement courant.
	 */
	@Override
	public double eval(IIndividu i) {
		//System.out.println("individu " + i);
		if (i.getValeurPropre() instanceof Double){
			return 1/(Math.pow((getValeur() - (double)i.getValeurPropre()),2));
		}
		return 0;
	}

}
