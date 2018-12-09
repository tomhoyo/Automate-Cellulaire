package View;

import java.awt.Color;

import javax.swing.JFrame;

import Model.Model;

public class Fenetre extends JFrame{
	
	private static final long serialVersionUID = 2542229582075632318L;
	Cellule cell;
	int tempsDAttente;

	public Fenetre(int longueurFenetre, int largeurFenetre, Color colorBackground,
					int RedIntansity, int GreenIntansity, int BlueIntansity, Model model) {
		
		setCell(new Cellule(RedIntansity, GreenIntansity, BlueIntansity, model));
		
	    this.setTitle("Automate Cellulaire");
	    this.setSize(largeurFenetre, longueurFenetre);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setBackground(colorBackground);        
	    this.setContentPane(getCell());
	    this.setVisible(true);	

	}

	public Cellule getCell() {
		return cell;
	}

	public void setCell(Cellule cell) {
		this.cell = cell;
	}
}
