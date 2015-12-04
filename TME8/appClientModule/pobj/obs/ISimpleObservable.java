/**
 * 
 */
package pobj.obs;

/**
 * @author TrungHieu
 *
 */
public interface ISimpleObservable {
	void addObserver(ISimpleObserver obs);
	void deleteObserver(ISimpleObserver obs);
}
