package View;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Model.Model;
 
public class Cellule extends JPanel implements Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4751793395101789708L;
	Model map;
	private boolean bool[][];
	private boolean tabBool[][];
	Color colorTrait;
	int VitesseChangeColor;
	int RedIntansity = 255, GreenIntansity, BlueIntansity; 
	
	public Cellule(int RedIntansity, int GreenIntansity, int BlueIntansity, Model map) {
		
		this.map = map;
		this.BlueIntansity = map.getBlueIntansity();
		this.GreenIntansity =  map.getGreenIntansity();
		this.RedIntansity =  map.getRedIntansity();
		this.bool = new boolean[map.getLongueur()][map.getLargeur()];
		this.tabBool = new boolean[map.getLongueur()][map.getLargeur()];
		
	}

	public void paintComponent(Graphics g){ 
		this.colorTrait = changeColor();
		for(int y = 0; y <= map.getLongueur()-1; y++) {
    		for(int x = 0; x <= map.getLargeur()-1; x++) {
	    		if(map.getPresentMap()[y][x] != map.getPreviousMap()[y][x] ) {
		    			if(map.getPresentMap()[x][y] == true) {
		        		    g.setColor(colorTrait);          
		    			}else if(map.getPresentMap()[x][y] == false) {
		        		    g.setColor(map.getColorinterieur());          
		    			}
		    		    g.fillRect(y * map.getEcartcellulehorizontal(), x * map.getEcartcellulevertical(),
		    		    		map.getLargeurcellule(), map.getLongueurcellule());
				}
			}
    	} 
		
	}
	
	Color changeColor() {
		if(this.RedIntansity==255 && this.GreenIntansity<255 && this.BlueIntansity==0) {
			this.GreenIntansity+=this.map.getVitesseChangeColor();
		}else if(this.RedIntansity>0 && this.GreenIntansity==255 && this.BlueIntansity==0) {
			this.RedIntansity-=this.map.getVitesseChangeColor();
		}else if(this.RedIntansity==0 && this.GreenIntansity==255 && this.BlueIntansity<255) {
			this.BlueIntansity+=this.map.getVitesseChangeColor();
		}else if(this.RedIntansity==0 && this.GreenIntansity>0 && this.BlueIntansity==255) {
			this.GreenIntansity-=this.map.getVitesseChangeColor();
		}else if(this.RedIntansity<255 && this.GreenIntansity==0 && this.BlueIntansity==255) {
			this.RedIntansity+=this.map.getVitesseChangeColor();
		}else if(this.RedIntansity==255 && this.GreenIntansity==0 && this.BlueIntansity>0) {
			this.BlueIntansity-=this.map.getVitesseChangeColor();
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

	@Override
	public void update(Observable arg0, Object arg1) {
		try {
	        Thread.sleep(10);
		} catch (InterruptedException e) {
	        e.printStackTrace();
		}
		this.setBool(map.getPresentMap());
		this.repaint();
	}

     
}