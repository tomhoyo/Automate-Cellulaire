package View;

import java.awt.Color;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
		int longueur;
		int largeur;
		int cadreLongueur;
		int cadreLargeur;
		int longueurCellule;
		int largeurCellule;
		int ecartCelluleHorizontal;
		int ecartCelluleVertical;
		int tempsDAttente;
		private Cellule cell;
	
	public Fenetre(boolean tab[][], int y, int x, int longueurCellule, 
					int largeurCellule, int ecartCelluleHorizontal, int ecartCelluleVertical, int tempsDAttente) {
		
		longueur = y;
		largeur = x;
		setCell(new Cellule(tab, longueur, largeur, longueurCellule, 
							largeurCellule, ecartCelluleHorizontal, ecartCelluleVertical));
		
		this.longueurCellule = longueurCellule;
		this.largeurCellule = largeurCellule;
		this.ecartCelluleHorizontal = ecartCelluleHorizontal;
		this.ecartCelluleVertical = ecartCelluleVertical;
		this.tempsDAttente = tempsDAttente;
		
	    this.setTitle("Automate Cellulaire");
	    this.setSize(largeur+20, longueur+43);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setContentPane(getCell());
	    this.setVisible(true);	

	}
	
	public void AfficherEvolution(boolean tab[][]) {
	    cell.setBackground(Color.WHITE);        
		try {
	        Thread.sleep(tempsDAttente);
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    this.setContentPane(new Cellule(tab, longueur, largeur, longueurCellule, 
	    								largeurCellule, ecartCelluleHorizontal, ecartCelluleVertical));

	    ActualiserFenetre();
	}


	private void ActualiserFenetre() {
	    this.setVisible(false);
	    this.setVisible(true);
	}

	public Cellule getCell() {
		return cell;
	}

	public void setCell(Cellule cell) {
		this.cell = cell;
	}
}
