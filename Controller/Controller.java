package Controller;
import View.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import Model.*;

public class Controller {
	
	private static final int nbrGeneration = 500;
	
	Map map;
	AffichageConsole console;
	Fenetre fenetre;
	
	public Controller() throws IOException {
		console = new AffichageConsole();
		map = new Map(InstancierMap());
		console.AfficherConsolle(map.getMap());
		fenetre = new Fenetre(map.getMap());

		for(int i = 0; i < nbrGeneration; i++) {
			map.setMap(ControlerMap());
			console.AfficherConsolle(map.getMap());
			fenetre.AfficherEvolution(map.getMap());
		}
	}
	

	
	public boolean[][] InstancierMap() throws IOException {
		boolean[][] mapBool = new boolean[20][20];
		mapBool[9][8] = true;
		mapBool[9][9] = true;
		mapBool[9][10] = true;
		mapBool[10][9] = true;
    	return mapBool;
	}
	
	
	public boolean[][] ControlerMap() {
		int survie;
		boolean tab[][] = new boolean[20][20];
		for(int y = 0; y <= 19; y++) {
    		for(int x = 0; x <= 19; x++) {
    			survie = 0;
    			if(y == 0 && x == 0) {
    				survie += ControlerCellule(map.getMap()[y][x+1]);
    				survie += ControlerCellule(map.getMap()[y+1][x]);
    				survie += ControlerCellule(map.getMap()[y+1][x]);

    			}else if(y == 0 && x > 0 && x < 19){
    				survie += ControlerCellule(map.getMap()[y][x-1]);
    				survie += ControlerCellule(map.getMap()[y][x+1]);
    				survie += ControlerCellule(map.getMap()[y+1][x-1]);
    				survie += ControlerCellule(map.getMap()[y+1][x]);
    				survie += ControlerCellule(map.getMap()[y+1][x+1]); 
    				
    			}else if(y == 0 && x == 19) {
    				survie += ControlerCellule(map.getMap()[y][x-1]);
    				survie += ControlerCellule(map.getMap()[y+1][x-1]);
    				survie += ControlerCellule(map.getMap()[y+1][x]);
    				
    			}else if(y != 0 &&  y != 19 && x == 19) {
    				survie += ControlerCellule(map.getMap()[y-1][x]);
    				survie += ControlerCellule(map.getMap()[y+1][x]);
    				survie += ControlerCellule(map.getMap()[y-1][x-1]);
    				survie += ControlerCellule(map.getMap()[y][x-1]);
    				survie += ControlerCellule(map.getMap()[y+1][x-1]);
    				
    			}else if(y == 19 && x == 19) {
    				survie += ControlerCellule(map.getMap()[y-1][x-1]);
    				survie += ControlerCellule(map.getMap()[y-1][x]);
    				survie += ControlerCellule(map.getMap()[y][x-1]);
    				
    			}else if(y == 19 && x != 0 && x != 19) {//
    				survie += ControlerCellule(map.getMap()[y][x-1]);
    				survie += ControlerCellule(map.getMap()[y][x+1]);
    				survie += ControlerCellule(map.getMap()[y-1][x-1]);
    				survie += ControlerCellule(map.getMap()[y-1][x]);
    				survie += ControlerCellule(map.getMap()[y-1][x+1]); 
    				
    			}else if(y == 19 && x == 0) {
    				survie += ControlerCellule(map.getMap()[y-1][x]);
    				survie += ControlerCellule(map.getMap()[y-1][x+1]);
    				survie += ControlerCellule(map.getMap()[y][x+1]);
    				
    			}else if(y != 0 && x == 0 || y != 19 && x == 0) {
    				survie += ControlerCellule(map.getMap()[y-1][x]);
    				survie += ControlerCellule(map.getMap()[y+1][x]);
    				survie += ControlerCellule(map.getMap()[y-1][x+1]);
    				survie += ControlerCellule(map.getMap()[y][x+1]);
    				survie += ControlerCellule(map.getMap()[y+1][x+1]);
    				
    			}else if(y != 0 || y != 19 || x != 19 || x != 19) {
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
		if(survie == 2 || survie == 3) {
			bool = true;
		}else if(survie != 2 || survie !=3) {
			bool = false;
		}
		return bool;
	}
}
