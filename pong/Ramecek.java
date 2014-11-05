package pong;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ramecek extends JFrame{
    public Ramecek(){
        this.setTitle("Pong Adíka a Budíka");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel hlavniPanel = new HlavniPanel();
        this.add(hlavniPanel);
        
        this.pack();
        this.setResizable(false);
    }
}
