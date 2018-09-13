package View;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Cellule extends JPanel {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		for(int y = 0; y <= 19; y++) {
    		for(int x = 0; x <= 19; x++) {
    			/*if(bool == true) {
        		    g.setColor(Color.GREEN);          
    			}else if(bool == false) {
        		    g.setColor(Color.BLACK);          

    			}*/

    		    g.fillRect(y * 22 + 2, x * 22 + 2, 20, 20);

    		}
    	} 

	}               
}