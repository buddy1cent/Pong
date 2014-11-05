package pong;

import java.awt.Graphics;
import java.awt.Color;

public class Tecka{
    
    private HlavniPanel panel;
    private Color barva;
    private final int VELIKOST_TECKY = 20;
    private int x,y;
    private int rychlost;
    private int smerX, smerY;
    
    public Tecka(HlavniPanel panel){
        this.panel = panel;
        this.barva = Color.WHITE;
        this.x = panel.getSIRKA_PANELU()/2;
        this.y = panel.getVYSKA_PANELU()/2;
        this.smerX = 1;
        this.smerY = 1;
        this.rychlost = 3;
    }  
    
    public void vykresliSe(Graphics g) {
        g.setColor(barva);
        g.fillRect(x, y, VELIKOST_TECKY, VELIKOST_TECKY);
    }
    
    public void move(){
        x += smerX;
        y += smerY;

        if ((x >= panel.getSIRKA_PANELU() - (VELIKOST_TECKY + 1)) || x <= 0) {
            smerX = -smerX;
        }
        if ((y >= panel.getVYSKA_PANELU() - (VELIKOST_TECKY + 1)) || (y <= 0)) {
            smerY = -smerY;
        }   
    }
    
}

