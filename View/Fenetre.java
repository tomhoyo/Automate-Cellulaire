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
	    this.setSize(1366, 768);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
	    //this.setVisible(false);
	    this.setBackground(Color.BLACK);        
	   // this.setVisible(true);
	}

	public Cellule getCell() {
		return cell;
	}

	public void setCell(Cellule cell) {
		this.cell = cell;
	}
}
