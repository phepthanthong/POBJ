/**
 * 
 */
package pobj.arith;

/**
 * @author TrungHieu
 *
 */
public class EnvEval {
	private double[] variables;
	
	/**
	 * Constructeur avec param�tre
	 * @param envSize
	 */
	public EnvEval(int envSize){
		variables = new double[envSize];
	}
	
	/**
	 * Associer une valeur (un nombre r�el) � chacune des variables contenues dans un tableau
	 * dont la taille fix�e � la construction correspond au nombre de variables du probl�me
	 * @param indexVariable la position dans le tableau
	 * @param val la valeur � associer
	 */
	public void setVariables(int indexVariable, double val){
		variables[indexVariable] = val;
	}
	/**
	 * Une fois l�environnement d��valuation rempli, on peut lui demander la valeur d�une variable donn�e par un entier
	 * @return indexVariable 
	 */
	public double getValue(int indexVariable){
		return variables[indexVariable];
	}
	
	@Override
	public String toString(){
		String str="";
		for (int i = 0; i < variables.length; i++){
			str += "X" + i +" : "+ variables[i] + "\n";
		}
		
		return str; 		
	}
}
