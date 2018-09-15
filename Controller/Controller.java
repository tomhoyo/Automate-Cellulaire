package Controller;
import View.*;
import java.io.IOException;
import Model.*;

public class Controller {
	
	//affecte le controller
	private static final int longueur = 700; // longueur et largeur doivent etres identiques
	private static final int largeur = 700;
	private static final int celluleAdjMin = 2;  // definit la forme 1-3
	private static final int celluleAdjMax = 4; // definit le fond toujours surperieur à "celluleAdjMin"
	private static final int nbrGeneration = 300; // definit la taille
	//affecte la view
	private static final int longueurCellule = 1; //finesse du trait
	private static final int largeurCellule = 1;
	private static final int ecartCelluleHorizontal = 1; // ecart entre chaque cellule
	private static final int ecartCelluleVertical = 1;
	private static final int tempsDAttente = 300; // temps d'attente entre chaques générations
	
	Map map;
	AffichageConsole console;
	private Fenetre fenetre;
	
	public Controller() throws IOException {
		map = new Map(InstancierMap(), longueur, largeur);
		setFenetre(new Fenetre(map.getMap(), longueur, largeur, longueurCellule, largeurCellule, 
								ecartCelluleHorizontal, ecartCelluleVertical, tempsDAttente));
		
		for(int i = 0; i < nbrGeneration; i++) {
			map.setMap(ControlerMap());
			getFenetre().AfficherEvolution(map.getMap());
		}
	}
	
	
	public boolean[][] InstancierMap() throws IOException {
		boolean[][] mapBool = new boolean[longueur][largeur];
		
		mapBool[(longueur/2)-3][(largeur/2)-3] = true;
		mapBool[(longueur/2)-3][(largeur/2)-2] = true;
		mapBool[(longueur/2)-3][(largeur/2)-1] = true;
		mapBool[(longueur/2)-3][(largeur/2)] = true;
		mapBool[(longueur/2)-3][(largeur/2)+1] = true;

		/*mapBool[(longueur/2)-2][(largeur/2)-3] = true;
		mapBool[(longueur/2)-2][(largeur/2)-2] = true;*/
		mapBool[(longueur/2)-2][(largeur/2)-1] = true;
		/*mapBool[(longueur/2)-2][(largeur/2)] = true;
		mapBool[(longueur/2)-2][(largeur/2)+1] = true;*/

		/*mapBool[(longueur/2)-1][(largeur/2)-3] = true;*/
		mapBool[(longueur/2)-1][(largeur/2)-2] = true;
		mapBool[(longueur/2)-1][(largeur/2)-1] = true;
		mapBool[(longueur/2)-1][(largeur/2)] = true;
		/*mapBool[(longueur/2)-1][(largeur/2)+1] = true;*/

		/*mapBool[(longueur/2)][(largeur/2)-3] = true;
		mapBool[(longueur/2)][(largeur/2)-2] = true;*/
		mapBool[(longueur/2)][(largeur/2)-1] = true;
		/*mapBool[(longueur/2)][(largeur/2)] = true;
		mapBool[(longueur/2)][(largeur/2)+1] = true;*/
		
		mapBool[(longueur/2)+1][(largeur/2)-3] = true;
		mapBool[(longueur/2)+1][(largeur/2)-2] = true;
		mapBool[(longueur/2)+1][(largeur/2)-1] = true;
		mapBool[(longueur/2)+1][(largeur/2)] = true;
		mapBool[(longueur/2)+1][(largeur/2)+1] = true;


    	return mapBool;
	}
	
	
	public boolean[][] ControlerMap() {// remplacer les if par des switch case
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
    				
    			}else if(y > 0 && y < longueur-1 && x > 0 && x < largeur-1) {
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


	public Fenetre getFenetre() {
		return fenetre;
	}


	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
}
