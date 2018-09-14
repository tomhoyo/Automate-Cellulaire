package View;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Cellule extends JPanel {

	
	private boolean bool[][];
	int longueur;
	int largeur;
	
	public Cellule(boolean tab[][], int y, int x) {
		longueur = y;
		largeur = x;
		bool = new boolean[longueur][largeur];
		setBool(tab);
	}

	public void paintComponent(Graphics g){
		for(int y = 0; y <= longueur-1; y++) {
    		for(int x = 0; x <= largeur-1; x++) {
    			if(getBool()[x][y] == true) {
        		    g.setColor(Color.GREEN);          
    			}else if(getBool()[x][y] == false) {
        		    g.setColor(Color.BLACK);          

    			}

    		    g.fillRect(y+2, x+2, 1, 1);

    		}
    	} 
	}

	boolean[][] getBool() {
		return bool;
	}

	void setBool(boolean bool[][]) {
		this.bool = bool;
	}               
}