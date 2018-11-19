package Controller;

import View.*;
import java.awt.Color;
import java.io.IOException;
import Model.*;

public class Controller {
	
	private Map map;
	private Fenetre fenetre;
	
	public Controller() throws IOException {
		map = new Map(InstancierMap(), Map.getLongueur(), Map.getLargeur());
		fenetre = new Fenetre(map.getMap(), Map.getLongueur(), Map.getLargeur(), Map.getLongueurcellule(), 
				Map.getLargeurcellule(), Map.getEcartcellulehorizontal(), Map.getEcartcellulevertical(), 
				Map.getTempsdattente(), Map.getColorbackground(), Map.getColortrait(), Map.getColorinterieur());
		
		for(int i = 0; i < Map.getNbrgeneration(); i++) {
			map.setMap(ControlerMap());
			fenetre.AfficherEvolution(map.getMap(), Map.getTempsdattente());
		}		
	}
	
	
	
	public boolean[][] InstancierMap() throws IOException {
		boolean[][] mapBool = new boolean[Map.getLongueur()][Map.getLargeur()];
		
		mapBool[(Map.getLongueur()/2)-3][(Map.getLargeur()/2)-3] = true;
		mapBool[(Map.getLongueur()/2)-3][(Map.getLargeur()/2)-2] = true;
		mapBool[(Map.getLongueur()/2)-3][(Map.getLargeur()/2)-1] = true;
		mapBool[(Map.getLongueur()/2)-3][(Map.getLargeur()/2)] = true;
		mapBool[(Map.getLongueur()/2)-3][(Map.getLargeur()/2)+1] = true;

		mapBool[(Map.getLongueur()/2)-2][(Map.getLargeur()/2)-3] = true;
		mapBool[(Map.getLongueur()/2)-2][(Map.getLargeur()/2)-2] = true;
		mapBool[(Map.getLongueur()/2)-2][(Map.getLargeur()/2)-1] = true;
		mapBool[(Map.getLongueur()/2)-2][(Map.getLargeur()/2)] = true;
		mapBool[(Map.getLongueur()/2)-2][(Map.getLargeur()/2)+1] = true;

		mapBool[(Map.getLongueur()/2)-1][(Map.getLargeur()/2)-3] = true;
		mapBool[(Map.getLongueur()/2)-1][(Map.getLargeur()/2)-2] = true;
		mapBool[(Map.getLongueur()/2)-1][(Map.getLargeur()/2)-1] = true;
		mapBool[(Map.getLongueur()/2)-1][(Map.getLargeur()/2)] = true;
		mapBool[(Map.getLongueur()/2)-1][(Map.getLargeur()/2)+1] = true;
		
		mapBool[(Map.getLongueur()/2)][(Map.getLargeur()/2)-3] = true;
		mapBool[(Map.getLongueur()/2)][(Map.getLargeur()/2)-2] = true;
		mapBool[(Map.getLongueur()/2)][(Map.getLargeur()/2)-1] = true;
		mapBool[(Map.getLongueur()/2)][(Map.getLargeur()/2)] = true;
		mapBool[(Map.getLongueur()/2)][(Map.getLargeur()/2)+1] = true;
		
		mapBool[(Map.getLongueur()/2)+1][(Map.getLargeur()/2)-3] = true;
		mapBool[(Map.getLongueur()/2)+1][(Map.getLargeur()/2)-2] = true;
		mapBool[(Map.getLongueur()/2)+1][(Map.getLargeur()/2)-1] = true;
		mapBool[(Map.getLongueur()/2)+1][(Map.getLargeur()/2)] = true;
		mapBool[(Map.getLongueur()/2)+1][(Map.getLargeur()/2)+1] = true;

    	return mapBool;
	}
	
	
	public boolean[][] ControlerMap() {
		int survie;
		boolean tab[][] = new boolean[Map.getLongueur()][Map.getLargeur()];
		for(int y = 1; y <= Map.getLongueur()-2; y++) {
    		for(int x = 1; x <= Map.getLargeur()-2; x++) {
				survie = ControlerCellule(map.getMap()[y-1][x-1])
				 + ControlerCellule(map.getMap()[y-1][x])
				 + ControlerCellule(map.getMap()[y-1][x+1])
				 + ControlerCellule(map.getMap()[y][x-1])
				 + ControlerCellule(map.getMap()[y][x+1])
				 + ControlerCellule(map.getMap()[y+1][x-1])
				 + ControlerCellule(map.getMap()[y+1][x])
				 + ControlerCellule(map.getMap()[y+1][x+1]);
				
				if(Map.getChoixsurvie() == true){
	    			tab[y][x] = Survie1(survie);
				}else if(Map.getChoixsurvie() == false){
	    			tab[y][x] = Survie2(survie, map.getMap()[y][x]);
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
	
	
	public boolean Survie1(int survie) {
		boolean bool = false;
		if(survie >= Map.getCelluleadjmin() && survie <= Map.getCelluleadjmax()) {
			bool = true;
		}else if(survie < Map.getCelluleadjmin() && survie > Map.getCelluleadjmax()) {
			bool = false;
		}
		return bool;
	}

	
	public boolean Survie2(int survie, boolean etat) {
		boolean bool = false;
		if(etat == true && survie >= Map.getCelluleadjmin() && survie <= Map.getCelluleadjmax() ) {
			bool = true;
		}else if(etat == false && survie == Map.getCelluleadjnaissance()) {
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
