package Model;

import java.awt.Color;

public class Map {
	 
//affecte le controller
	private static final int longueur = 700; // longueur et largeur doivent etres identiques
	private static final int largeur = 700;
	private static final  int celluleAdjMin = 1;  // definit la forme 1-3
	private static final  int celluleAdjMax = 5; // definit le fond toujours surperieur à "celluleAdjMin"
	private static final  int celluleAdjNaissance = 1;
	private static final int nbrGeneration = 3000; // definit la taille
	private static final  boolean choixSurvie = false; // choix du type de model de survie
//affecte la view
	private static final int longueurCellule = 1; //finesse du trait
	private static final int largeurCellule = 1;
	private static final int ecartCelluleHorizontal = 1; // ecart entre chaque cellule
	private static final int ecartCelluleVertical = 1;
	private static final int tempsDAttente = 10; // temps d'attente entre chaques générations
	private static final Color colorBackground = new Color(0, 0, 0);
	private static final Color colorTrait = new Color(255, 255, 255);
	private static final Color colorInterieur = new Color(0, 0, 0);
	
/////////////////////////////////////////
	
	private boolean map[][];
	
	public Map(boolean tab[][], int longueur, int largeur) {
		map = new boolean[longueur][largeur];
		setMap(tab);
	}

	public boolean[][] getMap() {
		return map;
	}

	public void setMap(boolean map[][]) {
		this.map = map;
	}

	public static int getLongueur() {
		return longueur;
	}

	public static int getLargeur() {
		return largeur;
	}

	public static int getCelluleadjmin() {
		return celluleAdjMin;
	}

	public static int getCelluleadjmax() {
		return celluleAdjMax;
	}

	public static int getCelluleadjnaissance() {
		return celluleAdjNaissance;
	}

	public static int getNbrgeneration() {
		return nbrGeneration;
	}

	public static boolean getChoixsurvie() {
		return choixSurvie;
	}

	public static int getLongueurcellule() {
		return longueurCellule;
	}

	public static int getLargeurcellule() {
		return largeurCellule;
	}

	public static int getEcartcellulehorizontal() {
		return ecartCelluleHorizontal;
	}

	public static int getEcartcellulevertical() {
		return ecartCelluleVertical;
	}

	public static int getTempsdattente() {
		return tempsDAttente;
	}

	public static Color getColorbackground() {
		return colorBackground;
	}

	public static Color getColortrait() {
		return colorTrait;
	}

	public static Color getColorinterieur() {
		return colorInterieur;
	}

}