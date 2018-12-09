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
	int RedIntansity = 255, GreenIntansity, BlueIntansity; 
	int x = 0;
	public Cellule(Model map) {
		
		this.setLayout(null);
		this.map = map;
		this.BlueIntansity = map.getBlueIntansity();
		this.GreenIntansity =  map.getGreenIntansity();
		this.RedIntansity =  map.getRedIntansity();
		this.bool = new boolean[map.getHeight()][map.getHeight()];
		this.tabBool = new boolean[map.getHeight()][map.getHeight()];
		
	}

	public void paintComponent(Graphics g){ 

		this.colorTrait = changeColor();
		for(int y = 0; y <= map.getHeight()-1; y++) {
    		for(int x = 0; x <= map.getHeight()-1; x++) {
	    		if(map.getPresentMap()[y][x] != map.getPreviousMap()[y][x] ) {
		    			if(map.getPresentMap()[x][y] == true) {
		        		    g.setColor(colorTrait);          
		    			}else if(map.getPresentMap()[x][y] == false) {
		        		    g.setColor(map.getColorbackground());          
		    			}
		    		    g.fillRect(y, x, 1, 1);
				}
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
		if(this.RedIntansity==255 && this.GreenIntansity<255 && this.BlueIntansity==0) {
			this.GreenIntansity+=this.map.getVitesseChangeColor();
		}else if(this.RedIntansity>0 && this.GreenIntansity==255 && this.BlueIntansity==0) {
			this.RedIntansity-=this.map.getVitesseChangeColor();
		}else if(this.RedIntansity==0 && this.GreenIntansity==255 && this.BlueIntansity<255) {
			this.BlueIntansity+=this.map.getVitesseChangeColor();
		}else if(this.RedIntansity==0 && this.GreenIntansity>0 && this.BlueIntansity==255) {
			this.GreenIntansity-=this.map.getVitesseChangeColor();
		}else if(this.RedIntansity<255 && this.GreenIntansity==0 && this.BlueIntansity==255) {
			this.RedIntansity+=this.map.getVitesseChangeColor();
		}else if(this.RedIntansity==255 && this.GreenIntansity==0 && this.BlueIntansity>0) {
			this.BlueIntansity-=this.map.getVitesseChangeColor();
		}
		return new Color(this.RedIntansity, this.GreenIntansity, this.BlueIntansity);
	}
	
	public void createFormulaire(Graphics g) {
			
		
		JComboBox boxCelluleAdjMin = new JComboBox();
	    boxCelluleAdjMin.addItem("1");
	    boxCelluleAdjMin.addItem("2");
	    boxCelluleAdjMin.addItem("3");
	    boxCelluleAdjMin.addItem("4");
	    boxCelluleAdjMin.addItem("5");
	    boxCelluleAdjMin.addItem("6");
	    boxCelluleAdjMin.addItem("7");
	    boxCelluleAdjMin.addItem("8");
	    this.add(boxCelluleAdjMin);
	    boxCelluleAdjMin.setBounds(map.getHeight() + 310, 45, 50, 25);
	    
	    JComboBox boxCelluleAdjMax = new JComboBox();
	    boxCelluleAdjMax.addItem("1");
	    boxCelluleAdjMax.addItem("2");
	    boxCelluleAdjMax.addItem("3");
	    boxCelluleAdjMax.addItem("4");
	    boxCelluleAdjMax.addItem("5");
	    boxCelluleAdjMax.addItem("6");
	    boxCelluleAdjMax.addItem("7");
	    boxCelluleAdjMax.addItem("8");
	    this.add(boxCelluleAdjMax);
	    boxCelluleAdjMax.setBounds(map.getHeight() + 350, 45+60, 50, 25);
	    
	    JComboBox boxModeSurvie = new JComboBox();
	    boxModeSurvie.addItem("1");
	    boxModeSurvie.addItem("2");
	    this.add(boxModeSurvie);
	    boxModeSurvie.setBounds(map.getHeight() + 135, 45+ 60*2, 50, 25);
	    
	    JComboBox boxcelluleAdjNaissance = new JComboBox();
	    boxcelluleAdjNaissance.addItem("1");
	    boxcelluleAdjNaissance.addItem("2");
	    boxcelluleAdjNaissance.addItem("3");
	    boxcelluleAdjNaissance.addItem("4");
	    boxcelluleAdjNaissance.addItem("5");
	    boxcelluleAdjNaissance.addItem("6");
	    boxcelluleAdjNaissance.addItem("7");
	    boxcelluleAdjNaissance.addItem("8");
	    this.add(boxcelluleAdjNaissance);
	    boxcelluleAdjNaissance.setBounds(map.getHeight() + 350, 45+60*3, 50, 25);
	    
	    TextField inputSleep = new TextField(5);
	    inputSleep.setText("30");
	    this.add(inputSleep);
	    inputSleep.setBounds(map.getHeight() + 300, 45 + 60*4, 50, 25);

	    
	    TextField inputBackgroundRed = new TextField("0", 5);
	    this.add(inputBackgroundRed);
	    inputBackgroundRed.setBounds(map.getHeight() + 140 + 70*0, 45 + 60*5, 50, 25);

	    
	    TextField inputBackgroundGreen = new TextField("0", 5);
	    this.add(inputBackgroundGreen);
	    inputBackgroundGreen.setBounds(map.getHeight() + 140 + 70*1, 45+60*5, 50, 25);

	    
	    TextField inputBackgroundBlue = new TextField("0", 5);
	    this.add(inputBackgroundBlue);
	    inputBackgroundBlue.setBounds(map.getHeight() + 140 + 70*2, 45+60*5, 50, 25);
	    
	    TextField inputTraitRed = new TextField("255", 5);
	    inputTraitRed.setText("255");
	    this.add(inputTraitRed);
	    inputTraitRed.setBounds(map.getHeight() + 200 + 70*0, 45 + 60*6, 50, 25);

	    
	    TextField inputTraitGreen = new TextField("0", 5);
	    this.add(inputTraitGreen);
	    inputTraitGreen.setBounds(map.getHeight() + 200 + 70*1, 45+60*6, 50, 25);

	    
	    TextField inputTraitBlue = new TextField("0", 5);
	    this.add(inputTraitBlue);
	    inputTraitBlue.setBounds(map.getHeight() + 200 + 70*2, 45+60*6, 50, 25);
	    
	    JComboBox boxVitesseChangeColor = new JComboBox();
	    boxVitesseChangeColor.addItem("1");
	    boxVitesseChangeColor.addItem("2");
	    boxVitesseChangeColor.addItem("3");
	    boxVitesseChangeColor.addItem("4");
	    boxVitesseChangeColor.addItem("5");
	    boxVitesseChangeColor.addItem("6");
	    boxVitesseChangeColor.addItem("7");
	    boxVitesseChangeColor.addItem("8");
	    this.add(boxVitesseChangeColor);
	    boxVitesseChangeColor.setBounds(map.getHeight() + 245, 45+60*7, 50, 25);
	    
	    
	    Button button = new Button("Activer l'automate");
	    button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				map.setTempsDAttente(Integer.parseInt(inputSleep.getText()));
				map.setsetColorBackground(Integer.parseInt(inputBackgroundRed.getText()), 
						Integer.parseInt(inputBackgroundGreen.getText())
						Integer.parseInt(inputBackgroundBlue.getText()));
				
				Integer.parseInt(inputTraitRed.getText());
				Integer.parseInt(inputTraitGreen.getText());
				Integer.parseInt(inputTraitBlue.getText());
			}
		});
	    this.add(button);
	    button.setBounds(map.getHeight() + 160, 45+60*8, 100, 25);
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