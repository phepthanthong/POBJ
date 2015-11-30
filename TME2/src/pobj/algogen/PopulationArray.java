/**
 * 
 */
package pobj.algogen;

import java.util.Arrays;

/**
 * @author TrungHieu
 *
 */
public class PopulationArray {
	private static final int POP_SIZE = 20;
	private Individu[] individus;
	private int size = 0;
	public PopulationArray(){
		individus = new Individu[POP_SIZE];
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	public void add(Individu individu){
		if (size < individus.length){
			individus[size] = individu;
			size++;
		} else {
			throw new ArrayIndexOutOfBoundsException("Plus de place!");
		}
	}
	@Override
	public String toString(){
		return Arrays.toString(individus);
	}
	
}
