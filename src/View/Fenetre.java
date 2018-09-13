package View;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	public Fenetre() {
		 //D�finit un titre pour notre fen�tre
	    this.setTitle("Automate Cellulaire");
	    //D�finit sa taille : 400 pixels de large et 100 pixels de haut
	    this.setSize(458, 481);
	    //Nous demandons maintenant � notre objet de se positionner au centre
	    this.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setContentPane(new Cellule());

	    this.setVisible(true);

	}
}
