package Model;

public class Map {
	 private static final int longueur = 20;
	 private static final int largeur = 20;

	private boolean map[][] = new boolean[longueur][largeur];
	
	public Map(boolean tab[][]) {
		setMap(tab);
	}

	public boolean[][] getMap() {
		return map;
	}

	public void setMap(boolean map[][]) {
		this.map = map;
	}

}