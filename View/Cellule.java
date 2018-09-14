package View;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Cellule extends JPanel {

	
	private boolean bool[][] = new boolean[20][20];
	
	public Cellule(boolean tab[][]) {
		setBool(tab);
	}

	public void paintComponent(Graphics g){
		for(int y = 0; y <= 19; y++) {
    		for(int x = 0; x <= 19; x++) {
    			if(getBool()[x][y] == true) {
        		    g.setColor(Color.GREEN);          
    			}else if(getBool()[x][y] == false) {
        		    g.setColor(Color.BLACK);          

    			}

    		    g.fillRect(y * 22 + 2, x * 22 + 2, 20, 20);

    		}
    	} 
		//this.repaint();
		this.revalidate();
	}

	boolean[][] getBool() {
		return bool;
	}

	void setBool(boolean bool[][]) {
		this.bool = bool;
	}               
}