/**
 * 
 */
package agent.laby;

import java.awt.Point;

/**
 * @author TrungHieu
 *
 */
public class CaseDepartNonVideException extends LabyErroneException {
	
	public CaseDepartNonVideException(Point casInitialEstVide){
		super("Erreur !!! La case initiale du labyrinth ne doit pas être vide !",casInitialEstVide);
	}
	
}
