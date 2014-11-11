package pong;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class Tecka{
    
    private HlavniPanel panel;
    private Color barva;
    private final int VELIKOST_TECKY = 20;
    private int x,y;
    private int rychlost;
    private int smerX, smerY;
    private int mimo;
    private Random rand;
    
    public Tecka(HlavniPanel panel){
        this.rand = new Random();
        this.panel = panel;
        this.barva = Color.WHITE;
        this.x = panel.getSIRKA_PANELU()/2;
        this.y = panel.getVYSKA_PANELU()/2;
        do{
            this.smerX = (rand.nextInt()%3-1)*2;
            this.smerY = (rand.nextInt()%3-1)*2;
        }while(smerX == 0);
        /*
        smerX = 5;
        smerY = 5;*/
        this.rychlost = 2;
        this.mimo = 0;
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
        //g.fillRect(x, y, VELIKOST_TECKY, VELIKOST_TECKY);
        g.fillOval(x, y, VELIKOST_TECKY, VELIKOST_TECKY);
    }
    public void turn(int x){
        if(smerX > 0)
            smerX = -x;
        else smerX = x;
    }
    
    public void setY(int y){
        if(smerY < 0)
            smerY = -y;
        else smerY = y;
    }
    
    public int mimoPanel(){
        return this.mimo;
    }
    public void reset(){
        do{
            this.smerX = (rand.nextInt()%3-1)*2;
            this.smerY = (rand.nextInt()%3-1)*2;
        }while(smerX == 0);
        
        this.x = panel.getSIRKA_PANELU()/2;
        this.y = panel.getVYSKA_PANELU()/2;
        this.mimo = 0;
    }
    public void move(){
        x += smerX;
        y += smerY;
        
        if(x <= 0)
            mimo = 2;
        else if ((x >= panel.getSIRKA_PANELU() - (VELIKOST_TECKY/2)) )
            mimo = 1;
        else 
            mimo = 0;
        if ((y >= panel.getVYSKA_PANELU() - (VELIKOST_TECKY/2)) || (y <= 0)) {
            smerY = -smerY;
        }
    }
    
}

