package Controller;
import View.*;

import java.awt.Color;
import java.io.IOException;
import Model.*;

public class Controller {
	
	//affecte le controller
		private static final int longueur = 700; // longueur et largeur doivent etres identiques
		private static final int largeur = 700;
		private int celluleAdjMin = 2;  // definit la forme 1-3
		private int celluleAdjMax = 3; // definit le fond toujours surperieur à "celluleAdjMin"
		private int celluleAdjNaissance = 2;
		private static final int nbrGeneration = 200; // definit la taille
		private boolean choixSurvie = false;
	//affecte la view
		private static final int longueurCellule = 1; //finesse du trait
		private static final int largeurCellule = 1;
		private static final int ecartCelluleHorizontal = 1; // ecart entre chaque cellule
		private static final int ecartCelluleVertical = 1;
		private static final int tempsDAttente = 10; // temps d'attente entre chaques générations
		private static final Color colorBackground = new Color(0, 0, 0);
		private static final Color colorTrait = new Color(255, 255, 255);
		private static final Color colorInterieur = new Color(0, 0, 0);
	
	private Map map;
	private Fenetre fenetre;
	
	
	public Controller() throws IOException {
		map = new Map(InstancierMap(), longueur, largeur);
		fenetre = new Fenetre(map.getMap(), longueur, largeur, longueurCellule, largeurCellule, 
								ecartCelluleHorizontal, ecartCelluleVertical, tempsDAttente, 
								colorBackground, colorTrait, colorInterieur);
		
		/*for(int a = 0; a < 2; a++) {
			
			for(int celluleAdjNaissance = 1; celluleAdjNaissance <= 8; celluleAdjNaissance++) {
				this.celluleAdjNaissance = celluleAdjNaissance;
				
				for(int celluleAdjMin = 1; celluleAdjMin <= 4; celluleAdjMin++) {
					this.celluleAdjMin = celluleAdjMin;
					
					for(int celluleAdjMax = celluleAdjMin; celluleAdjMax <= 8; celluleAdjMax++) {
						this.celluleAdjMax = celluleAdjMax;
						
						for(int i = 0; i < nbrGeneration; i++) {
							map.setMap(ControlerMap());
							fenetre.AfficherEvolution(map.getMap());
						}
						try {
					        Thread.sleep(500);
					      } catch (InterruptedException e) {
					        e.printStackTrace();
					      }
						
						map.setMap(InstancierMap());
						
					}
				}
			}
			this.choixSurvie = true;
		}*/
		
		
		for(int i = 0; i < nbrGeneration; i++) {
			map.setMap(ControlerMap());
			fenetre.AfficherEvolution(map.getMap());
		}
		
		
	}
	
	
	
	public boolean[][] InstancierMap() throws IOException {
		boolean[][] mapBool = new boolean[longueur][largeur];
		
		mapBool[(longueur/2)-3][(largeur/2)-3] = true;
		mapBool[(longueur/2)-3][(largeur/2)-2] = true;
		mapBool[(longueur/2)-3][(largeur/2)-1] = true;
		mapBool[(longueur/2)-3][(largeur/2)] = true;
		mapBool[(longueur/2)-3][(largeur/2)+1] = true;

		mapBool[(longueur/2)-2][(largeur/2)-3] = true;
		mapBool[(longueur/2)-2][(largeur/2)-2] = true;
		mapBool[(longueur/2)-2][(largeur/2)-1] = true;
		mapBool[(longueur/2)-2][(largeur/2)] = true;
		mapBool[(longueur/2)-2][(largeur/2)+1] = true;

		mapBool[(longueur/2)-1][(largeur/2)-3] = true;
		mapBool[(longueur/2)-1][(largeur/2)-2] = true;
		mapBool[(longueur/2)-1][(largeur/2)-1] = true;
		mapBool[(longueur/2)-1][(largeur/2)] = true;
		mapBool[(longueur/2)-1][(largeur/2)+1] = true;
		
		mapBool[(longueur/2)][(largeur/2)-3] = true;
		mapBool[(longueur/2)][(largeur/2)-2] = true;
		mapBool[(longueur/2)][(largeur/2)-1] = true;
		mapBool[(longueur/2)][(largeur/2)] = true;
		mapBool[(longueur/2)][(largeur/2)+1] = true;
		
		mapBool[(longueur/2)+1][(largeur/2)-3] = true;
		mapBool[(longueur/2)+1][(largeur/2)-2] = true;
		mapBool[(longueur/2)+1][(largeur/2)-1] = true;
		mapBool[(longueur/2)+1][(largeur/2)] = true;
		mapBool[(longueur/2)+1][(largeur/2)+1] = true;


    	return mapBool;
	}
	
	
	public boolean[][] ControlerMap() {
		int survie;
		boolean tab[][] = new boolean[longueur][largeur];
		for(int y = 1; y <= longueur-2; y++) {
    		for(int x = 1; x <= largeur-2; x++) {
    			survie = 0;
				survie += ControlerCellule(map.getMap()[y-1][x-1])
				 + ControlerCellule(map.getMap()[y-1][x])
				 + ControlerCellule(map.getMap()[y-1][x+1])
				 + ControlerCellule(map.getMap()[y][x-1])
				 + ControlerCellule(map.getMap()[y][x+1])
				 + ControlerCellule(map.getMap()[y+1][x-1])
				 + ControlerCellule(map.getMap()[y+1][x])
				 + ControlerCellule(map.getMap()[y+1][x+1]);
				
				if(choixSurvie == true) {
	    			tab[y][x] = Survie1(survie);

				}else if(choixSurvie == false){
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
		if(survie >= celluleAdjMin && survie <= celluleAdjMax) {
			bool = true;
		}else if(survie < celluleAdjMin && survie > celluleAdjMax) {
			bool = false;
		}
		return bool;
	}

	
	public boolean Survie2(int survie, boolean etat) {
		boolean bool = false;

			if(etat == true && survie >= celluleAdjMin && survie <= celluleAdjMax ) {
				bool = true;
			}else if(etat == false && survie == celluleAdjNaissance) {
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
