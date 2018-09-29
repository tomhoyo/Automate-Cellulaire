package View;

import java.awt.Color;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 2542229582075632318L;
		int longueur;
		int largeur;
		int cadreLongueur;
		int cadreLargeur;
		int longueurCellule;
		int largeurCellule;
		int ecartCelluleHorizontal;
		int ecartCelluleVertical;
		int tempsDAttente;
		Cellule cell;
		Color colorBackground;

	
	public Fenetre(boolean tab[][], int y, int x, int longueurCellule, int largeurCellule, 
					int ecartCelluleHorizontal, int ecartCelluleVertical, int tempsDAttente,
					Color colorBackground, Color colorTrait, Color colorInterieur) {
		
		longueur = y;
		largeur = x;
		setCell(new Cellule(tab, longueur, largeur, longueurCellule, 
							largeurCellule, ecartCelluleHorizontal, ecartCelluleVertical,
							 colorTrait, colorInterieur));
		
		this.longueurCellule = longueurCellule;
		this.largeurCellule = largeurCellule;
		this.ecartCelluleHorizontal = ecartCelluleHorizontal;
		this.ecartCelluleVertical = ecartCelluleVertical;
		this.tempsDAttente = tempsDAttente;
		this.colorBackground = colorBackground;
		
	    this.setTitle("Automate Cellulaire");
	    this.setSize(730, 739);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setBackground(this.colorBackground);        
	    this.setContentPane(getCell());
	    this.setVisible(true);	

	}
	
	public void AfficherEvolution(boolean tab[][]) {
		try {
	        Thread.sleep(tempsDAttente);
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
		
	    cell.setBool(tab);
	    ActualiserFenetre();
	}


	private void ActualiserFenetre() {
		cell.repaint();
	}

	public Cellule getCell() {
		return cell;
	}

	public void setCell(Cellule cell) {
		this.cell = cell;
	}
}
