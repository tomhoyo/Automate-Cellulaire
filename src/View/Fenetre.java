package View;

import javax.swing.JFrame;
import Model.Model;

public class Fenetre extends JFrame{
	
	private static final long serialVersionUID = 2542229582075632318L;
	Cellule cell;
	int tempsDAttente;
	
	public Fenetre(Model model) {
		
		setCell(new Cellule(model));
		
	    this.setTitle("Automate Cellulaire");
	    this.setSize(cell.map.getHeight() + 500, cell.map.getHeight());
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setBackground(cell.map.getColorBackground());        
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
