package View;

import javax.swing.JFrame;

public class Fenetre extends JFrame{

	public Fenetre(boolean tab[][]) {
		
		 //Définit un titre pour notre fenêtre
	    this.setTitle("Automate Cellulaire");
	    //Définit sa taille : 400 pixels de large et 100 pixels de haut
	    this.setSize(458, 481);
	    //Nous demandons maintenant à notre objet de se positionner au centre
	    this.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setContentPane(new Cellule(tab));
	    this.setVisible(true);

	}
	
	public void AfficherEvolution(boolean tab[][]) {
		try {
	        Thread.sleep(200);
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    this.setContentPane(new Cellule(tab));
	    ActualiserFenetre();
	}


	private void ActualiserFenetre() {
	    this.setVisible(false);
	    this.setVisible(true);
	}
}
