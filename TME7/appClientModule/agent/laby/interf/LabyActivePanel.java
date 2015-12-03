/**
 * 
 */
package agent.laby.interf;

import pobj.obs.ISimpleObserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import agent.laby.Labyrinthe;

/**
 * @author TrungHieu
 *
 */
public class LabyActivePanel extends LabyPanel implements ISimpleObserver, ActionListener  {

	public LabyActivePanel(Labyrinthe laby) {
		super(laby);
	}

	/* (non-Javadoc)
	 * @see pobj.obs.ISimpleObserver#update()
	 */
	@Override
	public void update() {

	}
	
	public static ActionListener test = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	};
	
}
