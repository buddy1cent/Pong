package pong;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Deska implements KeyListener{
    
    private HlavniPanel panel;
    private final int nahoru,dolu;
    private int x,y;
    private int rychlost;
    private int smer;
    private Color barva;
    private final int SIRKA_OBDELNIKU = 15;
    private final int VYSKA_OBDELNIKU = 60;
    
    public Deska(HlavniPanel panel,int hrac,int nahoru,int dolu){
        this.rychlost = 2;
        this.smer = 0;
        this.nahoru = nahoru;
        this.dolu = dolu;
        this.panel = panel;
        if(hrac == 1){
            
           this.x = panel.getSIRKA_PANELU() / 60; 
           this.barva = Color.BLUE;
        }
        else{
            this.x = panel.getSIRKA_PANELU() - SIRKA_OBDELNIKU;
            this.barva = Color.RED;
        }
        this.y = 0;
    }  
    
    public void vykresliSe(Graphics g) {
        g.setColor(barva);
        g.fillRect(x, y, SIRKA_OBDELNIKU, VYSKA_OBDELNIKU);
    }
    
    public void move(){
        y+= smer;
        
        if (y >= panel.getVYSKA_PANELU()- (VYSKA_OBDELNIKU + 1)) {
            y = panel.getVYSKA_PANELU()- (VYSKA_OBDELNIKU + 1);
        }
        if (y <= 0) {
            y = 0;
        }  
    }
    
    public Rectangle getOkraje() {
        return new Rectangle(x, y, SIRKA_OBDELNIKU, VYSKA_OBDELNIKU);
    }
    
    @Override
     public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == nahoru){
            smer = -rychlost;
        }
        else if(e.getKeyCode() == dolu){
            smer = rychlost;
        }
    }
     
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == nahoru){
            smer = 0;
        }
        else if(e.getKeyCode() == dolu){
            smer = 0;
        } 
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }    
}
