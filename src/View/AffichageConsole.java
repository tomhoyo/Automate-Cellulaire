package View;

public class AffichageConsole {
	int longueur;
	int largeur;
	
	
	public AffichageConsole(int y, int x) {
		longueur = y;
		largeur = x;
	}
	
	public void AfficherConsolle(boolean map[][]) {
		for(int y = 0; y <= longueur-1; y++) {
    		for(int x = 0; x <= largeur-1; x++) {
    			if(map[y][x] == true) {
        			System.out.print("11");
    			}else {
        			System.out.print("00");
    			}
    		}
    		System.out.println();	
    	} 
		System.out.println("\n");
	}
}
