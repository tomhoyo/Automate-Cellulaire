package Controller;

import View.*;
import java.io.IOException;
import Model.*;

public class Controller {
	
	private Model map;
	private Fenetre fenetre;
	
	public Controller() throws IOException {
		map = new Model();
		fenetre = new Fenetre(map.getPresentMap(),map.getLongueurFenetre(), map.getLargeurFenetre(), map.getLongueur(), 
				map.getLargeur(), map.getLongueurcellule(), map.getLargeurcellule(), map.getEcartcellulehorizontal(), 
				map.getEcartcellulevertical(), map.getTempsdattente(), map.getColorbackground(), map.getColorinterieur(), map.getVitesseChangeColor(),
				map.getRedIntansity(), map.getGreenIntansity(), map.getBlueIntansity());
		
		for(int numGeneration = 0; numGeneration < map.getNbrgeneration(); numGeneration++) {
			map.setPresentMap(ControlMap());
			fenetre.AfficherEvolution(map.getPresentMap());
		}		
	}
	
	private boolean[][] ControlMap() { 
		boolean tab[][] = new boolean[map.getLongueur()][map.getLargeur()];
		for(int y = 1; y <= map.getLongueur()-2; y++) {
    		for(int x = 1; x <= map.getLargeur()-2; x++) {
				if(map.getChoixsurvie() == true){
	    			tab[y][x] = Survie(CalculSurvie(x, y));
				}else if(map.getChoixsurvie() == false){
	    			tab[y][x] = Survie(CalculSurvie(x, y), map.getPresentMap()[y][x]);
				}
    		}
    	} 
		return tab;
	}
	
	private int CalculSurvie(int x, int y) {
			return ControlerCellule(map.getPresentMap()[y-1][x-1])
		 + ControlerCellule(map.getPresentMap()[y-1][x])
		 + ControlerCellule(map.getPresentMap()[y-1][x+1])
		 + ControlerCellule(map.getPresentMap()[y][x-1])
		 + ControlerCellule(map.getPresentMap()[y][x+1])
		 + ControlerCellule(map.getPresentMap()[y+1][x-1])
		 + ControlerCellule(map.getPresentMap()[y+1][x])
		 + ControlerCellule(map.getPresentMap()[y+1][x+1]);
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
		if(survie >= map.getCelluleadjmin() && survie <= map.getCelluleadjmax()) {
			return true;
		}else if(survie < map.getCelluleadjmin() && survie > map.getCelluleadjmax()) {
			return false;
		}
		return false;
	}

	
	public boolean Survie(int survie, boolean etat) {
		if(etat == true && survie >= map.getCelluleadjmin() && survie <= map.getCelluleadjmax() ) {
			return true;
		}else if(etat == false && survie == map.getCelluleadjnaissance()) {
			return true;
		}
		return false;
	}
	

	public Fenetre getFenetre() {
		return fenetre;
	}

	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
}
