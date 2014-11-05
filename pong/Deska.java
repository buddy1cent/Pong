/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author BUDDY_1cent
 */
public class Deska implements KeyListener{
    
    private HlavniPanel panel;
    private final int nahoru,dolu;
    private int x,y;
    private int rychlost;
    private int smer;
    private Color barva;
    private final int SIRKA_OBDELNIKA = 15;
    private final int VYSKA_OBDELNIKA = 60;
    
    public Deska(HlavniPanel panel,int hrac,int nahoru,int dolu){
        this.rychlost = 2;
        this.smer = 0;
        this.nahoru = nahoru;
        this.dolu = dolu;
        this.panel = panel;
        System.out.println(panel.getSIRKA_PANELU());
        if(hrac == 1){
            
           this.x = 10;//panel.getSIRKA_PANELU() / SIRKA_OBDELNIKA; 
           this.barva = Color.BLUE;
        }
        else{
            this.x = 600 - SIRKA_OBDELNIKA;//panel.getSIRKA_PANELU() - SIRKA_OBDELNIKA;
            this.barva = Color.RED;
        }
        this.y = 0;
    }  
    
    public void vykresliSe(Graphics g) {
        g.setColor(barva);
        g.fillRect(x, y, SIRKA_OBDELNIKA, VYSKA_OBDELNIKA);
    }
    
    public void move(){
        y+= smer;
        
        if (y >= panel.getVYSKA_PANELU()- (VYSKA_OBDELNIKA + 1)) {
            y = panel.getVYSKA_PANELU()- (VYSKA_OBDELNIKA + 1);
        }
        if (y <= 0) {
            y = 0;
        }  
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
    
    private class PosluchacCasovace implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //co se ma stat
           /* moveDot();
            moveLine1();
            moveLine2();
            repaint();*/
        }
    }
    
}
