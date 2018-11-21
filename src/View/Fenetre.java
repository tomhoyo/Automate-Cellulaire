package View;

import java.awt.Color;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	private static final long serialVersionUID = 2542229582075632318L;
	Cellule cell;
	int tempsDAttente;

	public Fenetre(boolean tab[][],int longueurFenetre, int largeurFenetre, int longueur, int largeur, 
					int longueurCellule, int largeurCellule, int ecartCelluleHorizontal, int ecartCelluleVertical, 
					int tempsDAttente, Color colorBackground, Color colorInterieur, int VitesseChangeColor,
					int RedIntansity, int GreenIntansity, int BlueIntansity) {
		
		setCell(new Cellule(tab, longueur, largeur, longueurCellule, largeurCellule, 
							ecartCelluleHorizontal, ecartCelluleVertical, colorInterieur, VitesseChangeColor,
							RedIntansity, GreenIntansity, BlueIntansity));
		this.tempsDAttente = tempsDAttente;
	    this.setTitle("Automate Cellulaire");
	    this.setSize(largeurFenetre, longueurFenetre);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setBackground(colorBackground);        
	    this.setContentPane(getCell());
	    this.setVisible(true);	

	}
	
	public void AfficherEvolution(boolean newMap[][]) {
		try {
	        Thread.sleep(this.tempsDAttente);
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
		
	    cell.setBool(newMap);
		cell.repaint();

	}

	public Cellule getCell() {
		return cell;
	}

	public void setCell(Cellule cell) {
		this.cell = cell;
	}
}
