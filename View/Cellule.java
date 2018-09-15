package View;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Cellule extends JPanel {

	private boolean bool[][];
	private boolean tabBool[][];
	int longueur;
	int largeur;
	int longueurCellule;
	int largeurCellule;
	int ecartCelluleHorizontal;
	int ecartCelluleVertical;
	
	public Cellule(boolean tab[][], int longueur, int largeur, int longueurCellule, int largeurCellule, 
					int ecartCelluleHorizontal, int ecartCelluleVertical) {
		
		this.longueurCellule = longueurCellule;
		this.largeurCellule = largeurCellule;
		this.ecartCelluleHorizontal = ecartCelluleHorizontal;
		this.ecartCelluleVertical = ecartCelluleVertical;
		this.longueur = longueur;
		this.largeur = largeur;
		this.bool = new boolean[longueur][largeur];
		setTabBool(new boolean[longueur][largeur]);
		setBool(tab);
	}

	public void paintComponent(Graphics g){ 
		for(int y = 0; y <= longueur-1; y++) {
    		for(int x = 0; x <= largeur-1; x++) {
	    		if(getBool()[y][x] != getTabBool()[y][x] ) {
	    			if(bool[x][y] == true) {
    				
		    			/*if(getBool()[x][y] == true) {
		        		    g.setColor(Color.BLACK);          
		    			}else if(getBool()[x][y] == false) {
		        		    g.setColor(Color.BLACK);          
		    			}*/
		    		    g.fillRect(y * ecartCelluleHorizontal + 2, x * ecartCelluleVertical+ 2,
		    		    		largeurCellule, longueurCellule);
		    		    
    		    	}
				}
			}
    	} 
		setTabBool(getBool());
	}

	boolean[][] getBool() {
		return bool;
	}

	void setBool(boolean bool[][]) {
		this.bool = bool;
	}

	public boolean[][] getTabBool() {
		return tabBool;
	}

	public void setTabBool(boolean tabBool[][]) {
		this.tabBool = tabBool;
	}

     
}