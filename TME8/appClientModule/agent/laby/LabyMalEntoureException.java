/**
 * 
 */
package agent.laby;

import java.awt.Point;

/**
 * @author TrungHieu
 *
 */
public class LabyMalEntoureException extends LabyErroneException {
		
	public LabyMalEntoureException(Point casPasDeMur){
		super("Erreur !!! Labyrinth doit être entouné par les murs !",casPasDeMur);
	}
}
