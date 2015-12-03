package agent;

import agent.control.IControleur;
import agent.laby.Labyrinthe;
import pobj.obs.SimpleObservable;

/**
 *  Cette classe reprÃ©sente un agent qui se dÃ©place dans un
 *         labyrinthe.
 *  @author sigaud
 */
public class Simulation extends SimpleObservable {

	/** L'agent qu'on simule */
	private Agent agent;
	
	/**
	 * Le labyrinthe dans lequel la simulation se dÃ©roule.
	 * Attention, ce labyrinthe est modifiÃ© au cours de la simulation.
	 */
	private Labyrinthe laby;

	
	/**
	 * Constructeur : initialise une simulation d'un contrÃ´leur donnÃ© dans un labyrinthe donnÃ©.
	 * @param m : le labyrinthe, sera modifiÃ© par la simulation
	 * @param c : le controleur
	 */
	public Simulation(Labyrinthe m, IControleur c) {
		laby = m;
		agent = new Agent(c, m.getPositionInitiale());
	}


	/**
	 * Rend le labyrinthe dans lequel la simulation Ã©volue.
	 * @return mon labyrinthe.
	 */
	public Labyrinthe getLaby() {
		return laby;
	}

	/**
	 * Renvoie le score de l'agent
	 */
	public int getScore() {
		return agent.getScore();
	}

	/**
	 * Effectue nbPas pas de l'agent dans le labyrinthe
	 * @param nbPas : le nombre de pas
	 * @return : le score de l'agent
	 */
	public int mesurePerf (int nbPas) {
		for (int i=0;i<nbPas;i++){
			agent.faitUnPas(getLaby());
			notifyObservers();
			
		}
		return agent.getScore();
	}
	
}
