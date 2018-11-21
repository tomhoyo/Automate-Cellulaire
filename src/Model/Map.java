package Model;

import java.awt.Color;

public class Map {
	 
//affecte le controller
	private int longueur = 700; // longueur et largeur doivent etres identiques
	private int largeur = 700;
	private int celluleAdjMin = 1;  // definit la forme 1-3
	private int celluleAdjMax = 5; // definit le fond toujours surperieur � "celluleAdjMin"
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
	private int tempsDAttente = 10; // temps d'attente entre chaques g�n�rations
	private Color colorBackground = new Color(0, 0, 0);
	private Color colorInterieur = new Color(0, 0, 0);
	private int VitesseChangeColor[] = new int[4];
	private int ViteChangCol = 2;
	private int RedIntansity = 255;
	private int GreenIntansity = 0;
	private int BlueIntansity = 0;
	
/////////////////////////////////////////
	
	private boolean presentMap[][];
	
	public Map() {
		
		presentMap = new boolean[getLongueur()][getLargeur()];
		setPresentMap(InstancierMap());
		
		this.VitesseChangeColor[0] = 0;
		this.VitesseChangeColor[1] = 1;
		this.VitesseChangeColor[2] = 5;
		this.VitesseChangeColor[3] = 15;

	}

	public boolean[][] InstancierMap() {
		
		presentMap[(getLongueur()/2)-3][(getLargeur()/2)-3] = true;
		presentMap[(getLongueur()/2)-3][(getLargeur()/2)-2] = true;
		presentMap[(getLongueur()/2)-3][(getLargeur()/2)-1] = true;
		presentMap[(getLongueur()/2)-3][(getLargeur()/2)] = true;
		presentMap[(getLongueur()/2)-3][(getLargeur()/2)+1] = true;

		presentMap[(getLongueur()/2)-2][(getLargeur()/2)-3] = true;
		presentMap[(getLongueur()/2)-2][(getLargeur()/2)-2] = true;
		presentMap[(getLongueur()/2)-2][(getLargeur()/2)-1] = true;
		presentMap[(getLongueur()/2)-2][(getLargeur()/2)] = true;
		presentMap[(getLongueur()/2)-2][(getLargeur()/2)+1] = true;

		presentMap[(getLongueur()/2)-1][(getLargeur()/2)-3] = true;		
		presentMap[(getLongueur()/2)-1][(getLargeur()/2)-2] = true;
		presentMap[(getLongueur()/2)-1][(getLargeur()/2)-1] = true;
		presentMap[(getLongueur()/2)-1][(getLargeur()/2)] = true;
		presentMap[(getLongueur()/2)-1][(getLargeur()/2)+1] = true;
		
		presentMap[(getLongueur()/2)][(getLargeur()/2)-3] = true;
		presentMap[(getLongueur()/2)][(getLargeur()/2)-2] = true;
		presentMap[(getLongueur()/2)][(getLargeur()/2)-1] = true;
		presentMap[(getLongueur()/2)][(getLargeur()/2)] = true;
		presentMap[(getLongueur()/2)][(getLargeur()/2)+1] = true;
		
		presentMap[(getLongueur()/2)+1][(getLargeur()/2)-3] = true;
		presentMap[(getLongueur()/2)+1][(getLargeur()/2)-2] = true;
		presentMap[(getLongueur()/2)+1][(getLargeur()/2)-1] = true;
		presentMap[(getLongueur()/2)+1][(getLargeur()/2)] = true;
		presentMap[(getLongueur()/2)+1][(getLargeur()/2)+1] = true;

    	return presentMap;
	}
	
	public boolean[][] getPresentMap() {
		return presentMap;
	}

	public void setPresentMap(boolean map[][]) {
		this.presentMap = map;
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

	public int getVitesseChangeColor() {
		return VitesseChangeColor[ViteChangCol];
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

	

}