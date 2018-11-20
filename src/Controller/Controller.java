package Controller;

import View.*;
import java.io.IOException;
import Model.*;

public class Controller {
	
	private Map map;
	private Fenetre fenetre;
	
	public Controller() throws IOException {
		map = new Map();
		fenetre = new Fenetre(map.getMap(),map.getLongueurFenetre(), map.getLargeurFenetre(), map.getLongueur(), map.getLargeur(), map.getLongueurcellule(), 
				map.getLargeurcellule(), map.getEcartcellulehorizontal(), map.getEcartcellulevertical(), 
				map.getTempsdattente(), map.getColorbackground(), map.getColortrait(), map.getColorinterieur());
		
		for(int i = 0; i < map.getNbrgeneration(); i++) {
			map.setMap(ControlerMap());
			fenetre.AfficherEvolution(map.getMap(), map.getTempsdattente());
		}		
	}
	
	public boolean[][] ControlerMap() {
		int survie;
		boolean tab[][] = new boolean[map.getLongueur()][map.getLargeur()];
		for(int y = 1; y <= map.getLongueur()-2; y++) {
    		for(int x = 1; x <= map.getLargeur()-2; x++) {
				survie = ControlerCellule(map.getMap()[y-1][x-1])
				 + ControlerCellule(map.getMap()[y-1][x])
				 + ControlerCellule(map.getMap()[y-1][x+1])
				 + ControlerCellule(map.getMap()[y][x-1])
				 + ControlerCellule(map.getMap()[y][x+1])
				 + ControlerCellule(map.getMap()[y+1][x-1])
				 + ControlerCellule(map.getMap()[y+1][x])
				 + ControlerCellule(map.getMap()[y+1][x+1]);
				
				if(map.getChoixsurvie() == true){
	    			tab[y][x] = Survie(survie);
				}else if(map.getChoixsurvie() == false){
	    			tab[y][x] = Survie(survie, map.getMap()[y][x]);
				}
    		}
    	} 
		return tab;
	}
	
	
	public int ControlerCellule(boolean cellule) {
		int var = 0;
				
		if(cellule == true) {
			var = 1;
		}if(cellule == false) {
			var = 0;
		}
		return var;
	}
		
	public boolean Survie(int survie) {
		boolean bool = false;
		if(survie >= map.getCelluleadjmin() && survie <= map.getCelluleadjmax()) {
			bool = true;
		}else if(survie < map.getCelluleadjmin() && survie > map.getCelluleadjmax()) {
			bool = false;
		}
		return bool;
	}

	
	public boolean Survie(int survie, boolean etat) {
		boolean bool = false;
		if(etat == true && survie >= map.getCelluleadjmin() && survie <= map.getCelluleadjmax() ) {
			bool = true;
		}else if(etat == false && survie == map.getCelluleadjnaissance()) {
			bool = true;
		}
		return bool;
	}
	

	public Fenetre getFenetre() {
		return fenetre;
	}


	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
}
