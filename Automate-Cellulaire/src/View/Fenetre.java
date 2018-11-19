package View;

import java.awt.Color;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	private static final long serialVersionUID = 2542229582075632318L;
	Cellule cell;

	public Fenetre(boolean tab[][], int longueur, int largeur, int longueurCellule, int largeurCellule, 
					int ecartCelluleHorizontal, int ecartCelluleVertical, int tempsDAttente,
					Color colorBackground, Color colorTrait, Color colorInterieur) {
		
		setCell(new Cellule(tab, longueur, largeur, longueurCellule, 
							largeurCellule, ecartCelluleHorizontal, ecartCelluleVertical,
							 colorTrait, colorInterieur));
		
	    this.setTitle("Automate Cellulaire");
	    this.setSize(716, 739);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setBackground(colorBackground);        
	    this.setContentPane(getCell());
	    this.setVisible(true);	

	}
	
	public void AfficherEvolution(boolean tab[][], int tempsDAttente) {
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
