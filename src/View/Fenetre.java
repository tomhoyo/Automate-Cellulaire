package View;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	
	public Fenetre() {
		 //Définit un titre pour notre fenêtre
	    this.setTitle("Automate Cellulaire");
	    //Définit sa taille : 400 pixels de large et 100 pixels de haut
	    this.setSize(500, 500);
	    //Nous demandons maintenant à notre objet de se positionner au centre
	    this.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    //Instanciation d'un objet JPanel
	    JPanel pan = new JPanel();
	    //Définition de sa couleur de fond
	    pan.setBackground(Color.WHITE);        
	    //On prévient notre JFrame que notre JPanel sera son content pane
	    this.setContentPane(pan);               
	    this.setVisible(true);

	}
}
