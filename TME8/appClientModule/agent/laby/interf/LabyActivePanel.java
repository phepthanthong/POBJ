/**
 * 
 */
package agent.laby.interf;

import pobj.obs.ISimpleObserver;
import java.awt.event.ActionEvent;
import agent.laby.Labyrinthe;

/**
 * @author TrungHieu
 *
 */
public class LabyActivePanel extends LabyPanel implements ISimpleObserver {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 */
	public LabyActivePanel(Labyrinthe laby) {
		super(laby);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pobj.obs.ISimpleObserver#update()
	 */
	@Override
	public void update() {
		super.updateGraphics();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
