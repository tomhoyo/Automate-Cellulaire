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
	int VitesseChangeColor;
	int RedIntansity = 255, GreenIntansity, BlueIntansity; 
	
	public Cellule(boolean tab[][], int longueur, int largeur, int longueurCellule, int largeurCellule, 
					int ecartCelluleHorizontal, int ecartCelluleVertical, Color colorInterieur, int VitesseChangeColor,
					int RedIntansity, int GreenIntansity, int BlueIntansity) {
		
		this.BlueIntansity = BlueIntansity;
		this.GreenIntansity = GreenIntansity;
		this.RedIntansity = RedIntansity;
		this.VitesseChangeColor = VitesseChangeColor;
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
		if(this.RedIntansity==255 && this.GreenIntansity<255 && this.BlueIntansity==0) {
			this.GreenIntansity+=this.VitesseChangeColor;
		}else if(this.RedIntansity>0 && this.GreenIntansity==255 && this.BlueIntansity==0) {
			this.RedIntansity-=this.VitesseChangeColor;
		}else if(this.RedIntansity==0 && this.GreenIntansity==255 && this.BlueIntansity<255) {
			this.BlueIntansity+=this.VitesseChangeColor;
		}else if(this.RedIntansity==0 && this.GreenIntansity>0 && this.BlueIntansity==255) {
			this.GreenIntansity-=this.VitesseChangeColor;
		}else if(this.RedIntansity<255 && this.GreenIntansity==0 && this.BlueIntansity==255) {
			this.RedIntansity+=this.VitesseChangeColor;
		}else if(this.RedIntansity==255 && this.GreenIntansity==0 && this.BlueIntansity>0) {
			this.BlueIntansity-=this.VitesseChangeColor;
		}
		return new Color(this.RedIntansity, this.GreenIntansity, this.BlueIntansity);
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