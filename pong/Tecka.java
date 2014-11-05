package pong;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

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
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public Rectangle getOkraje() {
        return new Rectangle(x, y, VELIKOST_TECKY, VELIKOST_TECKY);
    }
    
    public void vykresliSe(Graphics g) {
        g.setColor(barva);
        g.fillRect(x, y, VELIKOST_TECKY, VELIKOST_TECKY);
    }
    public void turn(){
        smerX = -smerX;
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

