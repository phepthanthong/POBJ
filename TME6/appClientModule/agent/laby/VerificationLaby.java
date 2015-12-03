/**
 * 
 */
package agent.laby;

import java.awt.Point;

/**
 * @author TrungHieu
 *
 */
public class VerificationLaby {
	private static void estEntoureDeMurs(Labyrinthe l) throws LabyMalEntoureException { 
		for (int i = 0; i < l.Xsize(); i++){
			if (l.getContenuCase(i, 0) != ContenuCase.MUR)
				throw new LabyMalEntoureException(new Point(i,0));
			if (l.getContenuCase(i, l.Ysize() -1 ) != ContenuCase.MUR)
				throw new LabyMalEntoureException(new Point(i,l.Ysize() - 1));
		}
		
		for (int i = 0; i < l.Ysize(); i++){
			if (l.getContenuCase(0, i) != ContenuCase.MUR)
				throw new LabyMalEntoureException(new Point(0,i));
			if (l.getContenuCase(l.Xsize() - 1, i) != ContenuCase.MUR)
				throw new LabyMalEntoureException(new Point(l.Xsize() - 1, i));
		}
			
	}
	
	private static void estCaseInitialeVide(Labyrinthe l) throws CaseDepartNonVideException{
		if (l.getContenuCase(l.getPositionInitiale()) != ContenuCase.VIDE)
			throw new CaseDepartNonVideException(l.getPositionInitiale());
			
	}
	
	public static void verifierConditions (Labyrinthe l) throws LabyErroneException{
		estCaseInitialeVide(l);
		estEntoureDeMurs(l);
	}
	
	public static int corrigerConditions(Labyrinthe l){
		int nbErreur = 0;
		while(true){
			try {
				verifierConditions(l);
				return nbErreur;
			}
			catch (LabyErroneException e){
				if (e instanceof LabyMalEntoureException){
					l.setContenuCase(e.getCaseErronee(), ContenuCase.MUR);
					System.out.println("Da sua MUR");
					nbErreur++;					
				}
				if (e instanceof CaseDepartNonVideException){
					l.setContenuCase(e.getCaseErronee(), ContenuCase.VIDE);
					System.out.println("Da sua VIDE");
					nbErreur++;
				}
			}
		}
		
		
	}
}
