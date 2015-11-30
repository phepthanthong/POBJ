package pobj.algogen;

public abstract class AbstractIndividu implements IIndividu {

	protected double fitness;

	public AbstractIndividu() {
		super();
	}

	/**
	 * @param newFitness the fitness to set
	 */
	public void setFitness(double newFitness) {
		this.fitness = newFitness;
	}

	/**
	 * @return the fitness
	 */
	public double getFitness() {
		return fitness;
	}

	@Override
	public int compareTo(IIndividu o) {
		if (getFitness() > o.getFitness())
			return -1;
		else if (getFitness() < o.getFitness())
			return 1;
		else return 0;
	}

	public abstract IIndividu clone();
}