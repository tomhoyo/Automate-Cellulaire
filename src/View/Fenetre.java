package View;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	public Fenetre() {
		 //Définit un titre pour notre fenêtre
	    this.setTitle("Automate Cellulaire");
	    //Définit sa taille : 400 pixels de large et 100 pixels de haut
	    this.setSize(458, 481);
	    //Nous demandons maintenant à notre objet de se positionner au centre
	    this.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setContentPane(new Cellule());

	    this.setVisible(true);

	}
}
