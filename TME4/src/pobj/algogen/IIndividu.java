package pobj.algogen;

public interface IIndividu extends Comparable<IIndividu> {

	/**
	 * @return the valeurPropre
	 */
	Object getValeurPropre();

	public double getFitness();

	public void setFitness(double newFitness);

	/**
	 * Cette m�thode doit rendre -1, 0 ou 1 selon que l�objet courant est plus
	 * petit, �gal ou plus grand que celui pass� en param�tre.
	 */
	int compareTo(IIndividu o);

	/**
	 * La mutation doit mettre � jour la valeur propre de l�individu de fa�on
	 * al�atoire.
	 */
	void muter();

	/**
	 * �tant donn� deux individus, le nouvel individu combine une partie des
	 * �l�ments du premier avec une partie des �l�ments du second.
	 * 
	 * @param autre
	 * @return un nouveau individu
	 */
	IIndividu croiser(IIndividu autre);

	/**
	 * copier les individus d�une population d�origine dans une nouvelle
	 * population.
	 */
	IIndividu clone();

}