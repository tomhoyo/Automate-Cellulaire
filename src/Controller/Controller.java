package Controller;

import View.*;
import java.io.IOException;
import Model.*;

public class Controller {
	
	private Model map;
	private Fenetre fenetre;
	
	public Controller() throws IOException {
		map = new Model();
		fenetre = new Fenetre(map);
		map.setObserver(fenetre.getCell());
		
		while(true) {
			map.ControlMap();	
		}
	}
	
	public Fenetre getFenetre() {
		return fenetre;
	}

	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
}
