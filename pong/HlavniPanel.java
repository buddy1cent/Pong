package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

class HlavniPanel extends JPanel {
    private final int SIRKA = 600;
    private final int VYSKA = 450;
    private Tecka tecka;
    private Deska deska1,deska2;
    private int body1,body2;
    private JLabel hrac1,hrac2,skore1,skore2;
    
    public HlavniPanel() {

        this.setPreferredSize(new Dimension(SIRKA, VYSKA));
        this.setBackground(Color.black);
        
        
        
        this.tecka = new Tecka(this);
        
        this.deska1 = new Deska(this,1,"Carl Johnson",KeyEvent.VK_W,KeyEvent.VK_S);
        this.deska2 = new Deska(this,2,"Johny Mlčoch",KeyEvent.VK_UP,KeyEvent.VK_DOWN);  
        
        this.addKeyListener(deska1);
        this.addKeyListener(deska2);
        
        this.setFocusable(true);
        
        hrac1 = new JLabel(deska1.getJmeno());
        hrac1.setForeground(Color.CYAN);
                
        hrac2 = new JLabel(deska2.getJmeno());
        hrac2.setForeground(Color.PINK);
        
        skore1 = new JLabel(deska1.getBody()+"");
        skore1.setFont(new Font("Sarif",Font.BOLD,30));
        skore1.setForeground(Color.WHITE);
        
        skore2 = new JLabel(deska2.getBody()+"");
        skore2.setFont(new Font("Sarif",Font.BOLD,30));
        skore2.setForeground(Color.WHITE);
        
        add(skore1);
        add(hrac1);
        add(hrac2);
        add(skore2);
        
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
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.GRAY);
        g.fillRect(this.SIRKA/2,2,5,VYSKA+5);
        
        tecka.vykresliSe(g);
        deska1.vykresliSe(g);
        deska2.vykresliSe(g);
    }
 
    private class PosluchacCasovace implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(deska1.jePripraven() && deska2.jePripraven()){
                Rectangle okrajeDesky1 = deska1.getOkraje();
                Rectangle okrajeDesky2 = deska2.getOkraje();
                Rectangle okrajeTecky = tecka.getOkraje();

                if (okrajeDesky1.intersects(okrajeTecky)){
                    tecka.turn(deska1.getRychlost());
                    tecka.setY(deska1.getRychlost());
                }
                if (okrajeDesky2.intersects(okrajeTecky)){
                    tecka.turn(deska2.getRychlost());
                    tecka.setY(deska2.getRychlost());
                }

                switch(tecka.mimoPanel()){
                    case 1: deska1.plusBod();
                            skore1.setText(deska1.getBody()+"");
                            tecka.reset();
                            break;
                    case 2: deska2.plusBod();
                            skore2.setText(deska2.getBody()+"");
                            tecka.reset();
                            break;
                    default:
                }

                tecka.move();
                deska1.move();
                deska2.move();

                repaint();
            }
        }
    }
}
