/**
 * 
 */
package agent.laby.interf;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import agent.Simulation;
import agent.control.ControlFactory;
import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;

/**
 * @author TrungHieu
 *
 */
public class LabyViewer extends JFrame {
	private static final long serialVersionUID = 1L;
	private int nbPas;
	private JPanel sidePanel;	
	private IControleur controleur;
	private Labyrinthe laby;
	private LabyActivePanel centerPanel;
	
	public LabyViewer(Labyrinthe l, IControleur c, int pas){
		this.laby = l;
		this.controleur = c;
		this.nbPas = pas;
		
		// creer les Panel et menus
		createCenterPanel();
		createSidePanel();				

		// Positionner la taille de la fenetre
		setSize(800, 758);
		setResizable(false);
		// traiter le clic sur la croix
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// rendre visible 
		setVisible(true);
	}
	
	/**
	 * Crée le MazePanel responsable d'afficher le Maze courant.
	 */
	private void createCenterPanel() {
		centerPanel = new LabyActivePanel(laby);
		getContentPane().add(centerPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Crée le panneau latéral, ses boutons et associe les actions appropriées aux boutons.
	 */
	private void createSidePanel() {
		sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));

		JButton play = new JButton("Play");		
		play.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Labyrinthe l = laby.clone();
				Simulation newSimul = new Simulation(l,controleur);
				centerPanel.setLaby(l);
				new Thread(new Runnable(){
					@Override
					public void run() {
						newSimul.addObserver(centerPanel);
						newSimul.mesurePerf(nbPas);
						newSimul.deleteObserver(centerPanel);
					}					
				}).start();
			}			
		});
		sidePanel.add(play);
		
		getContentPane().add(sidePanel, BorderLayout.EAST);

	}
	public static void main(String[] args) {
		String labyFile = "goal.mze"; // args[0];		
		int nbSteps = 50;
		try {
			Labyrinthe laby = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);			
			new LabyViewer(laby, ControlFactory.createSmartController(),nbSteps);

		} catch (IOException e) {
			System.out.println("Problème de chargement du labyrinthe"+e);
			System.exit(1);
		}
	}
}
