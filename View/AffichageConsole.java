package View;

public class AffichageConsole {
	
	public AffichageConsole() {
		
	}
	
	public void AfficherConsolle(boolean map[][]) {
		for(int y = 0; y <= 19; y++) {
    		for(int x = 0; x <= 19; x++) {
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
