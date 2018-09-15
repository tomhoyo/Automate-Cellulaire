package Model;

public class Map {
	 

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

}