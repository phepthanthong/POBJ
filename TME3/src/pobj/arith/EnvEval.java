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
	 * Constructeur avec paramètre
	 * @param envSize
	 */
	public EnvEval(int envSize){
		variables = new double[envSize];
	}
	
	/**
	 * Associer une valeur (un nombre réel) à chacune des variables contenues dans un tableau
	 * dont la taille fixée à la construction correspond au nombre de variables du problème
	 * @param indexVariable la position dans le tableau
	 * @param val la valeur à associer
	 */
	public void setVariables(int indexVariable, double val){
		variables[indexVariable] = val;
	}
	/**
	 * Une fois l’environnement d’évaluation rempli, on peut lui demander la valeur d’une variable donnée par un entier
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
