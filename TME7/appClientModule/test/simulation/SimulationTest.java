/**
 * 
 */
package test.simulation;

import java.io.IOException;

import agent.Simulation;
import agent.control.ControlFactory;
import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;
import agent.laby.VerificationLaby;
import junit.framework.TestCase;

/**
 * @author TrungHieu
 *
 */
public class SimulationTest extends TestCase {
	private Labyrinthe laby;
	/**
	 * @param name
	 */
	public SimulationTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		String labyFile = "test1.mze"; // args[0];

		try {
			laby = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);			

		} catch (IOException e) {
			System.out.println("Problème de chargement du labyrinthe"+e);
			System.exit(1);
		}
	}

	/**
	 * Test method for {@link agent.Simulation#mesurePerf(int)}.
	 */
	public void testMesurePerf() {
		//fail("Not yet implemented");
		int nbSteps = 50;
		//int nbRules = 10;
		IControleur sc = ControlFactory.createControleurDroitier();
		Simulation sim = new Simulation(laby, sc);
		System.out.println(sim.mesurePerf(nbSteps));
	}

}
