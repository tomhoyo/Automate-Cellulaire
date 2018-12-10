package View;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Model.Model;
 
public class Cellule extends JPanel implements Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4751793395101789708L;
	Model map;
	private boolean bool[][];
	private boolean tabBool[][];
	Color colorTrait;
	int VitesseChangeColor;
	//int RedIntansity = 255, GreenIntansity, BlueIntansity; 
	int x = 0;
	public Cellule(Model map) {
		
		this.setLayout(null);
		this.map = map;
		/*this.BlueIntansity = map.getBlueIntansity();
		this.GreenIntansity =  map.getGreenIntansity();
		this.RedIntansity =  map.getRedIntansity();*/
		this.bool = new boolean[map.getHeight()][map.getHeight()];
		this.tabBool = new boolean[map.getHeight()][map.getHeight()];
		
	}

	public void paintComponent(Graphics g){ 		
		this.colorTrait = changeColor();
		for(int y = 0; y <= map.getHeight()-1; y++) {
    		for(int x = 0; x <= map.getHeight()-1; x++) {
    			//if(map.getPresentMap()[y][x] != map.getPreviousMap()[y][x] ) {
		    			if(map.getPresentMap()[x][y] == true) {
		        		    g.setColor(colorTrait);
		        		    
		    			}else if(map.getPresentMap()[x][y] == false) {
		        		    g.setColor(map.getColorBackground());          
		    			}
		    		    g.fillRect(y, x, 1, 1);
				//}
			}
    	} 

		g.setColor(new Color(237, 217, 137));          
		g.fillRect(map.getHeight(),0,map.getHeight() + 400, map.getHeight());
		g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 16));
		g.drawString("Minimum de Cellule adjacente pour la survie :", map.getHeight() + 20, 60); // 0 - 8
		g.drawString("Maximum de Cellule adjacente pour avant la mort :", map.getHeight() + 20, 120); // 0 - 8
		g.drawString("Mode de survie :", map.getHeight() + 20, 180); // boolean
		g.drawString("Minimum de Cellule adjacente pour une naissance :", map.getHeight() + 20, 240); // 0 - 8
		g.drawString("Temps d'attente entre chaque génération :", map.getHeight() + 20, 300); // 0 - infinit
		g.drawString("Couleur de fond :", map.getHeight() + 20, 360); // rgb
		g.drawString("Couleur RGB de départ :", map.getHeight() + 20, 420); // rgb
		g.drawString("Vitesse de changement de couleur :", map.getHeight() + 20, 480); // 1 - 4
		if(x == 0) {

			x++;
			createFormulaire(g);
		}
	}
	
	Color changeColor() {
		if(this.map.getRedIntansity()==255 && this.map.getGreenIntansity()<255 && this.map.getBlueIntansity()==0) {
			this.map.setGreenIntansity(map.getGreenIntansity() + this.map.getVitesseChangeColor()[map.getShooseVitesseChangeColor()]);
		}else if(this.map.getRedIntansity()>0 && this.map.getGreenIntansity()==255 && this.map.getBlueIntansity()==0) {
			this.map.setRedIntansity(map.getRedIntansity() - this.map.getVitesseChangeColor()[map.getShooseVitesseChangeColor()]);
		}else if(this.map.getRedIntansity()==0 && this.map.getGreenIntansity()==255 && this.map.getBlueIntansity()<255) {
			this.map.setBlueIntansity(map.getBlueIntansity() + this.map.getVitesseChangeColor()[map.getShooseVitesseChangeColor()]);
		}else if(this.map.getRedIntansity()==0 && this.map.getGreenIntansity()>0 && this.map.getBlueIntansity()==255) {
			this.map.setGreenIntansity(map.getGreenIntansity() - this.map.getVitesseChangeColor()[map.getShooseVitesseChangeColor()]);
		}else if(this.map.getRedIntansity()<255 && this.map.getGreenIntansity()==0 && this.map.getBlueIntansity()==255) {
			this.map.setRedIntansity(map.getRedIntansity() + this.map.getVitesseChangeColor()[map.getShooseVitesseChangeColor()]);
		}else if(this.map.getRedIntansity()==255 && this.map.getGreenIntansity()==0 && this.map.getBlueIntansity()>0) {
			this.map.setBlueIntansity(map.getBlueIntansity() - this.map.getVitesseChangeColor()[map.getShooseVitesseChangeColor()]);
		}
		return new Color(this.map.getRedIntansity(), this.map.getGreenIntansity(), this.map.getBlueIntansity());
	}
	
	public void createFormulaire(Graphics g) {
	    
		/*g.setColor(new Color(237, 217, 137));          
		g.fillRect(map.getHeight(),0,map.getHeight() + 400, map.getHeight());
		g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 16));
		g.drawString("Minimum de Cellule adjacente pour la survie :", map.getHeight() + 20, 60); // 0 - 8
		g.drawString("Maximum de Cellule adjacente pour avant la mort :", map.getHeight() + 20, 120); // 0 - 8
		g.drawString("Mode de survie :", map.getHeight() + 20, 180); // boolean
		g.drawString("Minimum de Cellule adjacente pour une naissance :", map.getHeight() + 20, 240); // 0 - 8
		g.drawString("Temps d'attente entre chaque génération :", map.getHeight() + 20, 300); // 0 - infinit
		g.drawString("Couleur de fond :", map.getHeight() + 20, 360); // rgb
		g.drawString("Couleur RGB de départ :", map.getHeight() + 20, 420); // rgb
		g.drawString("Vitesse de changement de couleur :", map.getHeight() + 20, 480); // 1 - 4*/
		
		String[] box = {"1", "2", "3", "4", "5", "6", "7", "8"};
		
		JComboBox boxCelluleAdjMin = new JComboBox(box);
		boxCelluleAdjMin.setSelectedIndex(0);
	    this.add(boxCelluleAdjMin);
	    boxCelluleAdjMin.setBounds(map.getHeight()+310, 45, 50, 25);
	    
	    JComboBox boxCelluleAdjMax = new JComboBox(box);
	    boxCelluleAdjMax.setSelectedIndex(4);
	    this.add(boxCelluleAdjMax);
	    boxCelluleAdjMax.setBounds(map.getHeight()+350, 105, 50, 25);
	    
	    JComboBox boxModeSurvie = new JComboBox();
	    boxModeSurvie.addItem("true");
	    boxModeSurvie.addItem("false");
	    boxModeSurvie.setSelectedIndex(1);
	    this.add(boxModeSurvie);
	    boxModeSurvie.setBounds(map.getHeight()+135, 165, 50, 25);
	    
	    JComboBox boxcelluleAdjNaissance = new JComboBox(box);
	    boxcelluleAdjNaissance.setSelectedIndex(0);
	    this.add(boxcelluleAdjNaissance);
	    boxcelluleAdjNaissance.setBounds(map.getHeight()+350, 225, 50, 25);
	    
	    TextField inputSleep = new TextField(5);
	    inputSleep.setText("30");
	    this.add(inputSleep);
	    inputSleep.setBounds(map.getHeight()+300, 285, 50, 25);
	    
	    TextField inputBackgroundRed = new TextField("0", 5);
	    this.add(inputBackgroundRed);
	    inputBackgroundRed.setBounds(map.getHeight()+140, 345, 50, 25);
	    
	    TextField inputBackgroundGreen = new TextField("0", 5);
	    this.add(inputBackgroundGreen);
	    inputBackgroundGreen.setBounds(map.getHeight()+210, 345, 50, 25);
	    
	    TextField inputBackgroundBlue = new TextField("0", 5);
	    this.add(inputBackgroundBlue);
	    inputBackgroundBlue.setBounds(map.getHeight()+280, 345, 50, 25);
	    
	    TextField inputTraitRed = new TextField("255", 5);
	    inputTraitRed.setText("255");
	    this.add(inputTraitRed);
	    inputTraitRed.setBounds(map.getHeight()+200, 405, 50, 25);
	    
	    TextField inputTraitGreen = new TextField("0", 5);
	    this.add(inputTraitGreen);
	    inputTraitGreen.setBounds(map.getHeight()+270, 405, 50, 25);

	    TextField inputTraitBlue = new TextField("0", 5);
	    this.add(inputTraitBlue);
	    inputTraitBlue.setBounds(map.getHeight()+340, 405, 50, 25);
	    
	    JComboBox boxVitesseChangeColor = new JComboBox();
	    boxVitesseChangeColor.addItem("0");
	    boxVitesseChangeColor.addItem("1");
	    boxVitesseChangeColor.addItem("2");
	    boxVitesseChangeColor.addItem("3");
	    boxVitesseChangeColor.setSelectedIndex(1);
	    this.add(boxVitesseChangeColor);
	    boxVitesseChangeColor.setBounds(map.getHeight()+245, 475, 50, 25);
	    
	    
	    Button button = new Button("Activer l'automate");
	    button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				map.setCelluleAdjMin(Integer.parseInt((String)boxCelluleAdjMin.getSelectedItem()));
				map.setCelluleAdjMax(Integer.parseInt((String)boxCelluleAdjMax.getSelectedItem()));
				if((String)boxModeSurvie.getSelectedItem() == "true") {
					map.setChoixSurvie(true);
				}else if((String)boxModeSurvie.getSelectedItem() == "false"){
					map.setChoixSurvie(false);
				}
				map.setCelluleAdjNaissance(Integer.parseInt((String)boxcelluleAdjNaissance.getSelectedItem()));
				map.setTempsDAttente(Integer.parseInt(inputSleep.getText()));
				map.setColorBackground(Integer.parseInt(inputBackgroundRed.getText()), 
						Integer.parseInt(inputBackgroundGreen.getText()),
						Integer.parseInt(inputBackgroundBlue.getText()));
				map.setRedIntansity(Integer.parseInt(inputTraitRed.getText()));
				map.setGreenIntansity(Integer.parseInt(inputTraitGreen.getText()));
				map.setBlueIntansity(Integer.parseInt(inputTraitBlue.getText()));
				map.setShooseVitesseChangeColor(Integer.parseInt((String)boxVitesseChangeColor.getSelectedItem()));
				g.setColor(Color.BLACK);          
				g.fillRect(0, 0, map.getHeight(), map.getHeight());
				map.InstancierMap();
				
			}
		});
	    this.add(button);
	    button.setBounds(map.getHeight()+200, 545, 100, 25);
	}

	boolean[][] getBool() {
		return bool;
	}

	void setBool(boolean bool[][]) {
		this.bool = bool;
	}

	public boolean[][] getTabBool() {
		return tabBool;
	}

	public void setTabBool(boolean tabBool[][]) {
		this.tabBool = tabBool;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		try {
	        Thread.sleep(map.getTempsdattente());
		} catch (InterruptedException e) {
	        e.printStackTrace();
		}
		this.setBool(map.getPresentMap());
		this.repaint();
	}

     
}