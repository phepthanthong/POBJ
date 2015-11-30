/**
 * 
 */
package pobj.arith;

import java.util.Random;

/**
 * @author TrungHieu
 *
 */
public class ExpressionFactory {
	
	private static int MAXVARIABLE = 2;
	private static Random generateur = new Random();
	
	/**
	 * Constructeur par défaut
	 */
	public ExpressionFactory(){
		
	}
	
	/** 
	* Un constructeur pour des expressions binaires usuelles: +,-,*,/ 
	* @param op le type de l’opérande, {@link Operator}, PLUS,MOINS,MULT,DIV 
	* @param left operande gauche 
	* @param right operande droite 
	* @return une expression binaire 
	*/ 
	public static Expression createOperateurBinaire (Operator op, Expression left, Expression right) { 
		return new OperateurBinaire(op, left, right);
	}
	
	/** 
	* Un constructeur d’expressions constantes. 
	* @param constant sa valeur 
	* @return une constante 
	*/ 
	public static Expression createConstante(double constant) { 
		Constante c = new Constante(constant);
		return c;
	}
	
	/** 
	* Un constructeur de variables, identifiées par un entier compris entre 0 et MAXVARIABLES. 
	* La demande de création de variables d’indice plus grand entraine un accroissement de 
	* MAXVARIABLE (attribut static). 
	* @param id l’indice de la variable 
	* @return une Variable 
	*/ 
	public static Expression createVariable (int id) {
		if (id < MAXVARIABLE -1)
			MAXVARIABLE = id + 1;
		return new Variable(id);
	}
	
	/**
	 * Une opération permettant de créer un EnvEval aléatoire
	 */
	public static EnvEval createRandomEnvironment(int max){
		MAXVARIABLE = max;
		EnvEval e = new EnvEval(max);
		for (int i = 0; i < max; i++){
			e.setVariables(i, generateur.nextDouble());
		}
		return e;
	}
	
	/**
	 * Une méthode permettant de construire une expression aléatoire, qui ne contienne pas de divisions. 
	 * Les opérandes des opérateurs binaires seront eux-mêmes générés aléatoirement. 
	 * Les variables auront un indice aléatoire qui n’excède pas MAXVARIABLE.
	 */
	public static Expression createRandomExpression(int profondeur){
		int num;
		if (profondeur == 0)
			num = generateur.nextInt(2);
		else num = generateur.nextInt(4);
		
		switch (num){
		case 0:
			return createVariable(generateur.nextInt(MAXVARIABLE));
		case 1:
			return createConstante(generateur.nextDouble());
		default:
			return createOperateurBinaire(Operator.values()[generateur.nextInt(3)+1],createRandomExpression(profondeur-1), createRandomExpression(profondeur-1));
		}	
	}
	
	/**
	 * Une méthode permettant de construire une expression aléatoire, qui ne contienne pas de divisions. 
	 * Les opérandes des opérateurs binaires seront eux-mêmes générés aléatoirement. 
	 * Les variables auront un indice aléatoire qui n’excède pas MAXVARIABLE.
	 */
	public static Expression createRandomExpression(){
		int num;
		int profondeur = 3;
		if (profondeur == 0)
			num = generateur.nextInt(2);
		else num = generateur.nextInt(4);
		
		switch (num){
		case 0:
			return createVariable(generateur.nextInt(MAXVARIABLE));
		case 1:
			return createConstante(generateur.nextDouble());
		default:
			return createOperateurBinaire(Operator.values()[generateur.nextInt(3)+1],createRandomExpression(profondeur-1), createRandomExpression(profondeur-1));
		}	
	}
}
