/**
 * 
 */
package agent.laby;

import java.awt.Point;

/**
 * @author TrungHieu
 *
 */
public class LabyErroneException extends Exception {
	private Point caseErronee;
	
	/**
	 * @return the caseErronee
	 */
	public Point getCaseErronee() {
		return caseErronee;
	}

	public LabyErroneException(String message, Point p){
		super(message);
		this.caseErronee = p;		
	}
	
	
}
