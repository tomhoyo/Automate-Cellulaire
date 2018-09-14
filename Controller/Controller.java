package Controller;
import View.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Model.*;

public class Controller {
	private static final int longueur = 650;
	private static final int largeur = 650;
	private static final int celluleAdjMin = 2;
	private static final int celluleAdjMax = 5;
	private static final int nbrGeneration = 500;
	
	Map map;
	AffichageConsole console;
	Fenetre fenetre;
	
	public Controller() throws IOException {
		console = new AffichageConsole(longueur, largeur);
		map = new Map(InstancierMap(), longueur, largeur);
		//console.AfficherConsolle(map.getMap());
		fenetre = new Fenetre(map.getMap(), longueur, largeur);
		for(int i = 0; i < nbrGeneration; i++) {
			map.setMap(ControlerMap());
			//console.AfficherConsolle(map.getMap());
			fenetre.AfficherEvolution(map.getMap());
		}
	}
	

	
	public boolean[][] InstancierMap() throws IOException {
		boolean[][] mapBool = new boolean[longueur][largeur];
		
		mapBool[(longueur/2)-1][(largeur/2)-2] = true;
		mapBool[(longueur/2)-1][(largeur/2)-1] = true;
		mapBool[(longueur/2)-1][(largeur/2)] = true;
		mapBool[(longueur/2)][(largeur/2)-1] = true;
    	return mapBool;
	}
	
	
	public boolean[][] ControlerMap() {
		int survie;
		boolean tab[][] = new boolean[longueur][largeur];
		for(int y = 0; y <= longueur-1; y++) {
    		for(int x = 0; x <= largeur-1; x++) {
    			survie = 0;
    			if(y == 0 && x == 0) {
    				survie += ControlerCellule(map.getMap()[y][x+1]);
    				survie += ControlerCellule(map.getMap()[y+1][x]);
    				survie += ControlerCellule(map.getMap()[y+1][x]);

    			}else if(y == 0 && x > 0 && x < largeur-1){
    				survie += ControlerCellule(map.getMap()[y][x-1]);
    				survie += ControlerCellule(map.getMap()[y][x+1]);
    				survie += ControlerCellule(map.getMap()[y+1][x-1]);
    				survie += ControlerCellule(map.getMap()[y+1][x]);
    				survie += ControlerCellule(map.getMap()[y+1][x+1]); 
    				
    			}else if(y == 0 && x == largeur-1) {
    				survie += ControlerCellule(map.getMap()[y][x-1]);
    				survie += ControlerCellule(map.getMap()[y+1][x-1]);
    				survie += ControlerCellule(map.getMap()[y+1][x]);
    				
    			}else if(y > 0 &&  y < longueur-1 && x == largeur-1) {
    				survie += ControlerCellule(map.getMap()[y-1][x]);
    				survie += ControlerCellule(map.getMap()[y+1][x]);
    				survie += ControlerCellule(map.getMap()[y-1][x-1]);
    				survie += ControlerCellule(map.getMap()[y][x-1]);
    				survie += ControlerCellule(map.getMap()[y+1][x-1]);
    				
    			}else if(y == longueur-1 && x == largeur-1) {
    				survie += ControlerCellule(map.getMap()[y-1][x-1]);
    				survie += ControlerCellule(map.getMap()[y-1][x]);
    				survie += ControlerCellule(map.getMap()[y][x-1]);
    				
    			}else if(y == longueur-1 && x > 0 && x < largeur-1) {//
    				survie += ControlerCellule(map.getMap()[y][x-1]);
    				survie += ControlerCellule(map.getMap()[y][x+1]);
    				survie += ControlerCellule(map.getMap()[y-1][x-1]);
    				survie += ControlerCellule(map.getMap()[y-1][x]);
    				survie += ControlerCellule(map.getMap()[y-1][x+1]); 
    				
    			}else if(y == longueur-1 && x == 0) {
    				survie += ControlerCellule(map.getMap()[y-1][x]);
    				survie += ControlerCellule(map.getMap()[y-1][x+1]);
    				survie += ControlerCellule(map.getMap()[y][x+1]);
    				
    			}else if(y > 0 && y < longueur-1 && x == 0) {
    				survie += ControlerCellule(map.getMap()[y-1][x]);
    				survie += ControlerCellule(map.getMap()[y+1][x]);
    				survie += ControlerCellule(map.getMap()[y-1][x+1]);
    				survie += ControlerCellule(map.getMap()[y][x+1]);
    				survie += ControlerCellule(map.getMap()[y+1][x+1]);
    				
    			}else if(y != 0 || y != longueur-1 || x != largeur-1 || x != largeur-1) {
    				survie += ControlerCellule(map.getMap()[y-1][x-1]);
    				survie += ControlerCellule(map.getMap()[y-1][x]);
    				survie += ControlerCellule(map.getMap()[y-1][x+1]);
    				survie += ControlerCellule(map.getMap()[y][x-1]);
    				survie += ControlerCellule(map.getMap()[y][x+1]);
    				survie += ControlerCellule(map.getMap()[y+1][x-1]);
    				survie += ControlerCellule(map.getMap()[y+1][x]);
    				survie += ControlerCellule(map.getMap()[y+1][x+1]);
    			}
    			
    			tab[y][x] = Survie(survie);
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
		if(survie >= celluleAdjMin && survie <= celluleAdjMax) {
			bool = true;
		}else if(survie < celluleAdjMin && survie > celluleAdjMax) {
			bool = false;
		}
		return bool;
	}
}
