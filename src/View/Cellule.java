package View;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Cellule extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4751793395101789708L;
	private boolean bool[][];
	private boolean tabBool[][];
	int longueur;
	int largeur;
	int longueurCellule;
	int largeurCellule;
	int ecartCelluleHorizontal;
	int ecartCelluleVertical;
	Color colorTrait;
	Color colorInterieur;
	int x = 255, y, z, w = 0; 
	
	public Cellule(boolean tab[][], int longueur, int largeur, int longueurCellule, int largeurCellule, 
					int ecartCelluleHorizontal, int ecartCelluleVertical,
					Color colorTrait, Color colorInterieur) {
		
		this.colorTrait = colorTrait;
		this.colorInterieur = colorInterieur;
		this.longueurCellule = longueurCellule;
		this.largeurCellule = largeurCellule;
		this.ecartCelluleHorizontal = ecartCelluleHorizontal;
		this.ecartCelluleVertical = ecartCelluleVertical;
		this.longueur = longueur;
		this.largeur = largeur;
		this.bool = new boolean[longueur][largeur];
		this.tabBool = new boolean[longueur][largeur];
		
		setBool(tab);
	}

	public void paintComponent(Graphics g){ 
		this.colorTrait = changeColor();
		for(int y = 0; y <= longueur-1; y++) {
    		for(int x = 0; x <= largeur-1; x++) {
	    		if(getBool()[y][x] != getTabBool()[y][x] ) {
		    			if(getBool()[x][y] == true) {
		        		    g.setColor(colorTrait);          
		    			}else if(getBool()[x][y] == false) {
		        		    g.setColor(colorInterieur);          
		    			}
		    		    g.fillRect(y * ecartCelluleHorizontal, x * ecartCelluleVertical,
		    		    		largeurCellule, longueurCellule);
				}
			}
    	} 
		setTabBool(getBool());
	}
	
	Color changeColor() {
		if(this.x==255 && this.y<255 && this.z==0) {
			this.y+=5;
		}else if(this.x>0 && this.y==255 && this.z==0) {
			this.x-=5;
		}else if(this.x==0 && this.y==255 && this.z<255) {
			this.z+=5;
		}else if(this.x==0 && this.y>0 && this.z==255) {
			this.y-=5;
		}else if(this.x<255 && this.y==0 && this.z==255) {
			this.x+=5;
		}else if(this.x==255 && this.y==0 && this.z>0) {
			this.z-=5;
		}
		return new Color(this.x, this.y, this.z);
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