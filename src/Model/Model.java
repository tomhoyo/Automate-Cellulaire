package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable{
	 
//affecte le controller
	private int celluleAdjMin = 1;  // definit la forme 1-3
	private int celluleAdjMax = 5; // definit le fond toujours surperieur à "celluleAdjMin"
	private int celluleAdjNaissance = 1;
	private boolean choixSurvie = false; // choix du type de model de survie
//affecte la view
	private int tempsDAttente = 100; // temps d'attente entre chaques générations
	private Color colorBackground = new Color(0, 0, 0);
	private int VitesseChangeColor[] = new int[4];
	private int shooseVitesseChangeColor = 2;
	private int RedIntansity = 255;
	private int GreenIntansity = 0;
	private int BlueIntansity = 0;
	
	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private int height = (int)dimension.getHeight() - 40;
	private int width  = (int)dimension.getWidth();
	
/////////////////////////////////////////
	
	private boolean presentMap[][];
	private boolean previousMap[][];
	public Model() {
		setPreviousMap(new boolean[getHeight()][getHeight()]);
		presentMap = new boolean[getHeight()][getHeight()];
		setPresentMap(InstancierMap());
		InstancierVitesseChangeColor();
	}
	
	private void InstancierVitesseChangeColor() {
		this.VitesseChangeColor[0] = 0;
		this.VitesseChangeColor[1] = 1;
		this.VitesseChangeColor[2] = 5;
		this.VitesseChangeColor[3] = 15;
	}
	

	public boolean[][] InstancierMap() {
		for(int y = 1; y <= this.getHeight()-2; y++) {
    		for(int x = 1; x <= this.getHeight()-2; x++) {
				presentMap[y][x] = false;		
    		}
    	}
		for(int x = -3; x <= 1; x++) {
			for(int y = -3; y <= 1; y++) {
				presentMap[(getHeight()/2)+x][(getHeight()/2)+y] = true;
			}
		}
    	return presentMap;
	}
	////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////
	
	public void ControlMap() { 
		boolean tab[][] = new boolean[this.getHeight()][this.getHeight()];
		for(int y = 1; y <= this.getHeight()-2; y++) {
    		for(int x = 1; x <= this.getHeight()-2; x++) {
				if(this.getChoixsurvie() == true){
	    			tab[y][x] = Survie(CalculSurvie(x, y));
				}else if(this.getChoixsurvie() == false){
	    			tab[y][x] = Survie(CalculSurvie(x, y), this.getPresentMap()[y][x]);
				}
    		}
    	} 
		setPresentMap(tab);
	}
	
	private int CalculSurvie(int x, int y) {
			return ControlerCellule(this.getPresentMap()[y-1][x-1])
		 + ControlerCellule(this.getPresentMap()[y-1][x])
		 + ControlerCellule(this.getPresentMap()[y-1][x+1])
		 + ControlerCellule(this.getPresentMap()[y][x-1])
		 + ControlerCellule(this.getPresentMap()[y][x+1])
		 + ControlerCellule(this.getPresentMap()[y+1][x-1])
		 + ControlerCellule(this.getPresentMap()[y+1][x])
		 + ControlerCellule(this.getPresentMap()[y+1][x+1]);
	}
	
	
	private int ControlerCellule(boolean cellule) {				
		if(cellule == true) {
			return 1;
		}if(cellule == false) {
			return 0;
		}
		return 0;
	}
		
	private boolean Survie(int survie) {
		if(survie >= this.getCelluleadjmin() && survie <= this.getCelluleadjmax()) {
			return true;
		}else if(survie < this.getCelluleadjmin() && survie > this.getCelluleadjmax()) {
			return false;
		}
		return false;
	}

	
	public boolean Survie(int survie, boolean etat) {
		if(etat == true && survie >= this.getCelluleadjmin() && survie <= this.getCelluleadjmax() ) {
			return true;
		}else if(etat == false && survie == this.getCelluleadjnaissance()) {
			return true;
		}
		return false;
	}
	
	////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////
	
	public boolean[][] getPresentMap() {
		return presentMap;
	}
	
	public void setPresentMap(boolean map[][]) {
		this.setPreviousMap(presentMap);
		this.presentMap = map;
		if(getPresentMap() != getPreviousMap()) {
			this.notifyUpdate();
		}
	}

	public int getCelluleadjmin() {
		return celluleAdjMin;
	}

	public int getCelluleadjmax() {
		return celluleAdjMax;
	}

	public int getCelluleadjnaissance() {
		return celluleAdjNaissance;
	}

	public boolean getChoixsurvie() {
		return choixSurvie;
	}

	public int getTempsdattente() {
		return tempsDAttente;
	}
	
	public void setTempsDAttente(int tempsDAttente) {
		this.tempsDAttente = tempsDAttente;
	}

	private Color getColorBackground() {
		return colorBackground;
	}

	private void setColorBackground(int r, int g, int b) {
		this.colorBackground = new Color(r, g, b);
	}


	public int getVitesseChangeColor() {
		return VitesseChangeColor[shooseVitesseChangeColor];
	}

	public int getRedIntansity() {
		return RedIntansity;
	}

	public void setRedIntansity(int redIntansity) {
		RedIntansity = redIntansity;
	}

	public int getGreenIntansity() {
		return GreenIntansity;
	}

	public void setGreenIntansity(int greenIntansity) {
		GreenIntansity = greenIntansity;
	}

	public int getBlueIntansity() {
		return BlueIntansity;
	}

	public void setBlueIntansity(int blueIntansity) {
		BlueIntansity = blueIntansity;
	}

	public void setObserver(Observer o) {
		this.addObserver(o);
	}
	
	private void notifyUpdate() {
		this.setChanged();
		this.notifyObservers();
	}

	public boolean[][] getPreviousMap() {
		return previousMap;
	}

	private void setPreviousMap(boolean previousMap[][]) {
		this.previousMap = previousMap;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}


	

}