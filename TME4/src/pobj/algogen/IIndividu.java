package pobj.algogen;

public interface IIndividu extends Comparable<IIndividu> {

	/**
	 * @return the valeurPropre
	 */
	Object getValeurPropre();

	public double getFitness();

	public void setFitness(double newFitness);

	/**
	 * Cette méthode doit rendre -1, 0 ou 1 selon que l’objet courant est plus
	 * petit, égal ou plus grand que celui passé en paramètre.
	 */
	int compareTo(IIndividu o);

	/**
	 * La mutation doit mettre à jour la valeur propre de l’individu de façon
	 * aléatoire.
	 */
	void muter();

	/**
	 * étant donné deux individus, le nouvel individu combine une partie des
	 * éléments du premier avec une partie des éléments du second.
	 * 
	 * @param autre
	 * @return un nouveau individu
	 */
	IIndividu croiser(IIndividu autre);

	/**
	 * copier les individus d’une population d’origine dans une nouvelle
	 * population.
	 */
	IIndividu clone();

}