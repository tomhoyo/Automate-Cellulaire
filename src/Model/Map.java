package Model;

import java.awt.Color;

public class Map {
	 
//affecte le controller
	private int longueur = 700; // longueur et largeur doivent etres identiques
	private int largeur = 700;
	private int celluleAdjMin = 1;  // definit la forme 1-3
	private int celluleAdjMax = 5; // definit le fond toujours surperieur à "celluleAdjMin"
	private int celluleAdjNaissance = 1;
	private int nbrGeneration = 3000; // definit la taille
	private boolean choixSurvie = false; // choix du type de model de survie
//affecte la view
	private int longueurFenetre = 739; // 716
	private int largeurFenetre = 716; // 739
	private int longueurCellule = 1; //finesse du trait
	private int largeurCellule = 1;
	private int ecartCelluleHorizontal = 1; // ecart entre chaque cellule
	private int ecartCelluleVertical = 1;
	private int tempsDAttente = 10; // temps d'attente entre chaques générations
	private Color colorBackground = new Color(0, 0, 0);
	private Color colorInterieur = new Color(0, 0, 0);
	
/////////////////////////////////////////
	
	private boolean map[][];
	
	public Map() {
		map = new boolean[getLongueur()][getLargeur()];
		setMap(InstancierMap());
	}

	public boolean[][] InstancierMap() {
		
		map[(getLongueur()/2)-3][(getLargeur()/2)-3] = true;
		map[(getLongueur()/2)-3][(getLargeur()/2)-2] = true;
		map[(getLongueur()/2)-3][(getLargeur()/2)-1] = true;
		map[(getLongueur()/2)-3][(getLargeur()/2)] = true;
		map[(getLongueur()/2)-3][(getLargeur()/2)+1] = true;

		map[(getLongueur()/2)-2][(getLargeur()/2)-3] = true;
		map[(getLongueur()/2)-2][(getLargeur()/2)-2] = true;
		map[(getLongueur()/2)-2][(getLargeur()/2)-1] = true;
		map[(getLongueur()/2)-2][(getLargeur()/2)] = true;
		map[(getLongueur()/2)-2][(getLargeur()/2)+1] = true;

		map[(getLongueur()/2)-1][(getLargeur()/2)-3] = true;		
		map[(getLongueur()/2)-1][(getLargeur()/2)-2] = true;
		map[(getLongueur()/2)-1][(getLargeur()/2)-1] = true;
		map[(getLongueur()/2)-1][(getLargeur()/2)] = true;
		map[(getLongueur()/2)-1][(getLargeur()/2)+1] = true;
		
		map[(getLongueur()/2)][(getLargeur()/2)-3] = true;
		map[(getLongueur()/2)][(getLargeur()/2)-2] = true;
		map[(getLongueur()/2)][(getLargeur()/2)-1] = true;
		map[(getLongueur()/2)][(getLargeur()/2)] = true;
		map[(getLongueur()/2)][(getLargeur()/2)+1] = true;
		
		map[(getLongueur()/2)+1][(getLargeur()/2)-3] = true;
		map[(getLongueur()/2)+1][(getLargeur()/2)-2] = true;
		map[(getLongueur()/2)+1][(getLargeur()/2)-1] = true;
		map[(getLongueur()/2)+1][(getLargeur()/2)] = true;
		map[(getLongueur()/2)+1][(getLargeur()/2)+1] = true;

    	return map;
	}
	
	public boolean[][] getMap() {
		return map;
	}

	public void setMap(boolean map[][]) {
		this.map = map;
	}

	public int getLongueur() {
		return longueur;
	}

	public int getLargeur() {
		return largeur;
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

	public int getNbrgeneration() {
		return nbrGeneration;
	}

	public boolean getChoixsurvie() {
		return choixSurvie;
	}

	public int getLongueurcellule() {
		return longueurCellule;
	}

	public  int getLargeurcellule() {
		return largeurCellule;
	}

	public int getEcartcellulehorizontal() {
		return ecartCelluleHorizontal;
	}

	public int getEcartcellulevertical() {
		return ecartCelluleVertical;
	}

	public int getTempsdattente() {
		return tempsDAttente;
	}

	public Color getColorbackground() {
		return colorBackground;
	}

	public Color getColorinterieur() {
		return colorInterieur;
	}

	public int getLongueurFenetre() {
		return longueurFenetre;
	}

	public void setLongueurFenetre(int longueurFenetre) {
		this.longueurFenetre = longueurFenetre;
	}

	public int getLargeurFenetre() {
		return largeurFenetre;
	}

	public void setLargeurFenetre(int largeurFenetre) {
		this.largeurFenetre = largeurFenetre;
	}

}