package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

class HlavniPanel extends JPanel {
    private final int SIRKA = 600;
    private final int VYSKA = 450;
    private Tecka tecka;
    private Deska deska1,deska2;
    
    public HlavniPanel() {
        
        this.setPreferredSize(new Dimension(SIRKA, VYSKA));
        this.setBackground(Color.black);
        
        this.tecka = new Tecka(this);
        
        this.deska1 = new Deska(this,1,KeyEvent.VK_W,KeyEvent.VK_S);
        this.deska2 = new Deska(this,2,KeyEvent.VK_UP,KeyEvent.VK_DOWN);  
        
        this.addKeyListener(deska1);
        this.addKeyListener(deska2);
        
        this.setFocusable(true);

        PosluchacCasovace posluchac = new PosluchacCasovace();
        Timer casovac = new Timer(10, posluchac);
        casovac.start();      
    }
    
    
    public int getSIRKA_PANELU(){
        return SIRKA;
    }
    
    public int getVYSKA_PANELU(){
        return VYSKA;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        tecka.vykresliSe(g);
        deska1.vykresliSe(g);
        deska2.vykresliSe(g);
    }
 
    private class PosluchacCasovace implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Rectangle okrajeDesky1 = deska1.getOkraje();
            Rectangle okrajeDesky2 = deska2.getOkraje();
            Rectangle okrajeTecky = tecka.getOkraje();
            
            if (okrajeDesky1.intersects(okrajeTecky))
                tecka.turn();
            if (okrajeDesky2.intersects(okrajeTecky))
                tecka.turn();

            tecka.move();
            deska1.move();
            deska2.move();

            repaint();
        }
    }
}
