/**
 * 
 */
package pobj.obs;

import java.util.ArrayList;

/**
 * @author TrungHieu
 *
 */
public class SimpleObservable implements ISimpleObservable {
	private ArrayList<ISimpleObserver> obs;
	/* (non-Javadoc)
	 * @see pobj.obs.ISimpleObservable#addObserver(pobj.obs.ISimpleObserver)
	 */
	@Override
	public void addObserver(ISimpleObserver o) {
		obs.add(o);
	}

	/* (non-Javadoc)
	 * @see pobj.obs.ISimpleObservable#deleteObserver(pobj.obs.ISimpleObserver)
	 */
	@Override
	public void deleteObserver(ISimpleObserver o) {
		obs.remove(o);
	}

	public void notifyObservers(){
		for (ISimpleObserver o : obs){
			o.update();
		}
	}
}
