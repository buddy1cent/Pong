package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

class HlavniPanel extends JPanel {
    private final int SIRKA = 600;
    private final int VYSKA = 450;
    private final int VELIKOST_TECKY = 20;
    private int x,y;
    private int smerX, smerY;
    private int rychlost;
    private Deska deska1,deska2;
    
    public HlavniPanel() {
        
        this.setPreferredSize(new Dimension(VYSKA, SIRKA));
        this.setBackground(Color.black);
        
        this.x = this.getWidth()/2;
        this.y = this.getHeight()/2;
        this.smerX = 1;
        this.smerY = 1;
        this.rychlost = 3;
        this.deska1 = new Deska(this,1,KeyEvent.VK_W,KeyEvent.VK_S);
        this.deska2 = new Deska(this,2,KeyEvent.VK_UP,KeyEvent.VK_DOWN);

        this.addKeyListener(deska1);
        this.addKeyListener(deska2);
        
        this.setFocusable(true);

        PosluchacCasovace posluchac = new PosluchacCasovace();
        Timer casovac = new Timer(10, posluchac);
        casovac.start();      
    }
    
    private void moveDot() {
        x += smerX;
        y += smerY;

        if ((x >= this.getWidth() - (VELIKOST_TECKY + 1)) || x <= 0) {
            smerX = -smerX;
        }
        if ((y >= this.getHeight() - (VELIKOST_TECKY + 1)) || (y <= 0)) {
            smerY = -smerY;
        }   
    }
    
    public int getSIRKA_PANELU(){
        return SIRKA;
    }
    
    public int getVYSKA_PANELU(){
        return VYSKA;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(x,y,VELIKOST_TECKY,VELIKOST_TECKY);
        deska1.vykresliSe(g);
        deska2.vykresliSe(g);
    }
 
    private class PosluchacCasovace implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveDot();
            deska1.move();
            deska2.move();
            repaint();
        }
    }
}
