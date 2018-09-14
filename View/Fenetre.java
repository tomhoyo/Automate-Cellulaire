package View;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	int longueur;
	int largeur;
	int cadreLongueur;
	int cadreLargeur;

	public Fenetre(boolean tab[][], int y, int x) {
		longueur = y;
		largeur = x;


		
	    this.setTitle("Automate Cellulaire");
	    this.setSize(largeur+20, longueur+43);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setContentPane(new Cellule(tab, longueur, largeur));
	    this.setVisible(true);

	}
	
	public void AfficherEvolution(boolean tab[][]) {
		try {
	        Thread.sleep(300);
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    this.setContentPane(new Cellule(tab, longueur, largeur));
	    ActualiserFenetre();
	}


	private void ActualiserFenetre() {
	    this.setVisible(false);
	    this.setVisible(true);
	}
}
